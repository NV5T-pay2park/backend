package pay2parkbackend.service.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pay2parkbackend.exception.ResourceNotFoundException;
import pay2parkbackend.model.entityFromDB.ParkingLot;
import pay2parkbackend.model.entityFromDB.PriceTicket;
import pay2parkbackend.model.parking.ParkingDetailData;
import pay2parkbackend.model.parking.ParkingListData;
import pay2parkbackend.model.parking.PriceTicketData;
import pay2parkbackend.repository.ParkingRepository;
import pay2parkbackend.repository.PriceTicketRepository;

import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingServiceImpl implements  ParkingService{

    @Autowired
    private ParkingRepository parkingRepository;
    @Autowired
    private PriceTicketRepository priceTicketRepository;


    @Override
    public List<ParkingListData> getAllParking (){
        var rawData = parkingRepository.findAll();
        List<ParkingListData> parkingList = new ArrayList<ParkingListData>();

        for (ParkingLot parkingLot : rawData ){

            parkingList.add(parkingLot.toParkingListData(parkingLot));

        }
        return parkingList;
    }

    @Override
    public ParkingDetailData getParkingById(Long parkingLotId){
        var parking = parkingRepository.findById(parkingLotId).orElseThrow(() -> new ResourceNotFoundException("Parking lot not exist with id: "+parkingLotId));
        List<PriceTicket> priceTicketList = new ArrayList<PriceTicket>();
        priceTicketList = priceTicketRepository.findByParkingLotId(parking);
        List<PriceTicketData> priceTicketDataList = new ArrayList<PriceTicketData>();
        for (PriceTicket priceTicket: priceTicketList){
            priceTicketDataList.add(priceTicket.toPriceTicketData(priceTicket));
        }
        return parking.toParkingDetailData(parking, priceTicketDataList);
    }
}
