package pay2park.service.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Service;

import pay2park.exception.ResourceNotFoundException;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.ParkingLotImage;
import pay2park.model.entityFromDB.PriceTicket;
import pay2park.model.image.ImageResponse;
import pay2park.model.parking.ParkingDetailData;
import pay2park.model.parking.ParkingListData;
import pay2park.model.parking.PriceTicketData;
import pay2park.repository.ParkingLotImageRepository;
import pay2park.repository.ParkingLotRepository;

import pay2park.repository.PriceTicketRepository;
import pay2park.util.functions.Distance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private PriceTicketRepository priceTicketRepository;
    @Autowired
    private ParkingLotImageRepository parkingLotImageRepository;

    @Override
    public List<ParkingListData> getAllParking() {
        List<ParkingLot> rawData = parkingLotRepository.findAll();
        List<ParkingListData> parkingList = new ArrayList<ParkingListData>();

        for (ParkingLot parkingLot : rawData) {
            parkingList.add(new ParkingListData(parkingLot, 0.0, 0, getImageList(parkingLotImageRepository.getAllImageByParkingLot(parkingLot))));
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

        if (coordinates.equals("")) {
            return new ParkingDetailData(parking, 0.0, 0, priceTicketDataList, getImageList(parkingLotImageRepository.getAllImageByParkingLot(parking)));
        } else {
            String[] parts1 = coordinates.split(",");
            double userLong = Double.parseDouble(parts1[0]);
            double userLat = Double.parseDouble(parts1[1]);

            Distance distance = new Distance();

            String returnDistance = Distance.getDistanceAndTimeGgApi(userLong, userLat, parking.getLat(), parking.getLng());
            String[] parts2 = returnDistance.split(",");
            return new ParkingDetailData(parking, Double.parseDouble(parts2[0]), Integer.parseInt(parts2[1]), priceTicketDataList, getImageList(parkingLotImageRepository.getAllImageByParkingLot(parking)));
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
                List<Integer> parkingLotIdList = new ArrayList<Integer>();
                if (vehicleTypeParts.length == 1) {
                    parkingLotIdList = priceTicketRepository.filterIdWithAVehicleType(typesInt.get(0));
                } else {
                    List<Integer> parkingLotIdList1 = priceTicketRepository.filterIdWithAVehicleType(typesInt.get(0));
                    List<Integer> parkingLotIdList2 = priceTicketRepository.filterIdWithAVehicleType(typesInt.get(1));
                    parkingLotIdList1.retainAll(parkingLotIdList2);
                    parkingLotIdList = parkingLotIdList1;
                }

                rawData = parkingLotRepository.searchWithStringSearchAndIdList(stringSearch, parkingLotIdList);
                if (rawData.size() == 0) {
                    rawData = parkingLotRepository.searchWithLikeStringSearchAndIdList(stringSearch, parkingLotIdList);
                }

            } else {
                if (vehicleTypeParts.length == 1) {
                    rawData = priceTicketRepository.filterWithAVehicleType(typesInt.get(0));
                } else {
                    List<ParkingLot> rawData1 = priceTicketRepository.filterWithAVehicleType(typesInt.get(0));
                    List<ParkingLot> rawData2 = priceTicketRepository.filterWithAVehicleType(typesInt.get(1));
                    rawData1.retainAll(rawData2);
                    rawData = rawData1;

                }

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

//            Distance distance = new Distance();
            for (ParkingLot parkingLot : rawData) {
                double dt = Distance.getDistance(userLong, userLat, parkingLot.getLat(), parkingLot.getLng());
                int time = (int) (dt * 3.5);
                parkingList.add(new ParkingListData(parkingLot, dt, time, getImageList(parkingLotImageRepository.getAllImageByParkingLot(parkingLot))));

            }
            parkingList.sort(new Comparator<ParkingListData>() {
                public int compare(ParkingListData s1, ParkingListData s2) {
                    return s1.getDistance().compareTo(s2.getDistance());
                }
            });
        } else {
            for (ParkingLot parkingLot : rawData) {
                parkingList.add(new ParkingListData(parkingLot, 0.0, 0, getImageList(parkingLotImageRepository.getAllImageByParkingLot(parkingLot))));
            }
        }

        if (!district.equals("Tất cả")) {
            final String dt = district;
            CollectionUtils.filter(parkingList, o -> ((ParkingListData) o).getDistrict().equals(dt));
        }
        return parkingList;
    }

    private List<ImageResponse> getImageList(List<ParkingLotImage> parkingLotImages) {
        return parkingLotImages.stream().map(i -> new ImageResponse(i.getId(), i.getUrl())).collect(Collectors.toList());
    }
}
