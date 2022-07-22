package pay2park.service.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pay2park.exception.ResourceNotFoundException;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.PriceTicket;
import pay2park.model.parking.ParkingDetailData;
import pay2park.model.parking.ParkingListData;
import pay2park.model.parking.PriceTicketData;
import pay2park.repository.ParkingRepository;
import pay2park.repository.PriceTicketRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.websocket.OnClose;
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

    @Override
    public List<ParkingListData> getParkingWithFilter(String coordinates,String stringSearch,String vehicleTypes){
        var parkingList = parkingRepository.findAll();
        return null;
    }
}
