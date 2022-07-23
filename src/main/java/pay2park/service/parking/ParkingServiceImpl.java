package pay2park.service.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pay2park.exception.ResourceNotFoundException;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.PriceTicket;
import pay2park.model.parking.ParkingDetailData;
import pay2park.model.parking.ParkingListData;
import pay2park.model.parking.PriceTicketData;
import pay2park.repository.ParkingLotRepository;

import pay2park.repository.PriceTicketRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingServiceImpl implements  ParkingService{

    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Autowired
    private PriceTicketRepository priceTicketRepository;


    @Override
    public List<ParkingListData> getAllParking (){
        List<ParkingLot> rawData = parkingLotRepository.findAll();
        List<ParkingListData> parkingList = new ArrayList<ParkingListData>();

        for (ParkingLot parkingLot : rawData ){

            parkingList.add(new ParkingListData(parkingLot));

        }
        return parkingList;
    }



    @Override
    public ParkingDetailData getParkingById(Integer parkingLotId){
        ParkingLot parking = parkingLotRepository.findById(parkingLotId).orElseThrow(() -> new ResourceNotFoundException("Parking lot not exist with id: "+parkingLotId));
        List<PriceTicket> priceTicketList = new ArrayList<PriceTicket>();
        priceTicketList = priceTicketRepository.findByParkingLotId(parking);
        List<PriceTicketData> priceTicketDataList = new ArrayList<PriceTicketData>();
        for (PriceTicket priceTicket: priceTicketList){
            priceTicketDataList.add(new PriceTicketData(priceTicket));
        }
        return new ParkingDetailData(parking, priceTicketDataList);
    }

    @Override
    public List<ParkingListData> getParkingWithFilter(String coordinates,String stringSearch,String vehicleTypes){
        List<ParkingLot> parkingList = parkingLotRepository.findAll();
        return null;
    }
}
