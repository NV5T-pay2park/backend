package pay2park.service.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Service;

import pay2park.exception.ResourceNotFoundException;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.PriceTicket;
import pay2park.model.parking.ParkingDetailData;
import pay2park.model.parking.ParkingListData;
import pay2park.model.parking.PriceTicketData;
import pay2park.repository.ParkingLotRepository;

import pay2park.repository.PriceTicketRepository;
import pay2park.util.functions.Distance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private PriceTicketRepository priceTicketRepository;


    @Override
    public List<ParkingListData> getAllParking() {
        List<ParkingLot> rawData = parkingLotRepository.findAll();
        List<ParkingListData> parkingList = new ArrayList<ParkingListData>();

        for (ParkingLot parkingLot : rawData) {

            parkingList.add(new ParkingListData(parkingLot, 3.4, 4));

        }
        return parkingList;
    }


    @Override
    public ParkingDetailData getParkingById(Integer parkingLotId, String coordinates) throws IOException {
        ParkingLot parking = parkingLotRepository.findById(parkingLotId).orElseThrow(() -> new ResourceNotFoundException("Parking lot not exist with id: " + parkingLotId));
        List<PriceTicket> priceTicketList = new ArrayList<PriceTicket>();
        priceTicketList = priceTicketRepository.findByParkingLotId(parking);

        List<PriceTicketData> priceTicketDataList = new ArrayList<PriceTicketData>();

        for (PriceTicket priceTicket : priceTicketList) {
            priceTicketDataList.add(new PriceTicketData(priceTicket));
        }

        if (coordinates == "") {
            return new ParkingDetailData(parking, 0.0, 0, priceTicketDataList);
        } else {
            String[] parts1 = coordinates.split(",");
            double userLong = Double.parseDouble(parts1[0]);
            double userLat = Double.parseDouble(parts1[1]);

            Distance distance = new Distance();

            String returnDistance = distance.getDistanceAndTimeGgApi(userLong, userLat, parking.getLat(), parking.getIng());
            String[] parts2 = returnDistance.split(",");
            return new ParkingDetailData(parking, Double.parseDouble(parts2[0]), Integer.parseInt(parts2[1]), priceTicketDataList);
        }
    }

    @Override
    public List<ParkingListData> searchAndFilterParking(String stringSearch, String vehicleTypes, String district, String coordinates) {
        List<ParkingListData> parkingList = new ArrayList<ParkingListData>();
        List<ParkingLot> rawData = new ArrayList<ParkingLot>();

        if (!vehicleTypes.equals("")) {
            String[] vehicleTypeParts = vehicleTypes.split(",");
            List<Integer> typesInt = new ArrayList<Integer>();
            for (String value : vehicleTypeParts) {
                typesInt.add(Integer.parseInt(value));
            }
            if (!stringSearch.equals("")) {
                List<Integer> parkingLotIdList = parkingLotRepository.filterIdWithVehicleType(typesInt);
                rawData = parkingLotRepository.searchWithStringSearchAndIdList(stringSearch, parkingLotIdList);
                if (rawData.size() == 0) {
                    rawData = parkingLotRepository.searchWithLikeStringSearchAndIdList(stringSearch, parkingLotIdList);
                }
            } else {
                rawData = parkingLotRepository.filterWithVehicleType(typesInt);
            }

        } else {
            if (!stringSearch.equals("")) {
                rawData = parkingLotRepository.searchWithStringSearch(stringSearch);
                if (rawData.size() == 0) {
                    rawData = parkingLotRepository.searchWithLikeStringSearch(stringSearch);
                }
            } else {
                rawData = parkingLotRepository.findAll();
            }
        }


        // distance
        if (!coordinates.equals("")) {
            String[] coordinateParts = coordinates.split(",");
            double userLong = Double.parseDouble(coordinateParts[0]);
            double userLat = Double.parseDouble(coordinateParts[1]);

            Distance distance = new Distance();
            for (ParkingLot parkingLot : rawData) {
                Double dt = distance.getDistance(userLong, userLat, parkingLot.getLat(), parkingLot.getIng());
                int time = (int) (dt * 4);
                parkingList.add(new ParkingListData(parkingLot, dt, time));

            }
            Collections.sort(parkingList, new Comparator<ParkingListData>() {
                public int compare(ParkingListData s1, ParkingListData s2) {
                    return s1.getDistance().compareTo(s2.getDistance());
                }
            });
        } else {
            for (ParkingLot parkingLot : rawData) {
                parkingList.add(new ParkingListData(parkingLot, 0.0, 0));
            }
        }

        if (!district.equals("Tất cả")) {
            final String dt = district;
            CollectionUtils.filter(parkingList, o -> ((ParkingListData) o).getDistrict().equals(dt));
        }

        return parkingList;
    }
}
