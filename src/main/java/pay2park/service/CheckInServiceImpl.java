package pay2park.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pay2park.model.*;
import pay2park.repositories.EndUserRepository;
import pay2park.repositories.ParkingLotRepository;
import pay2park.repositories.TicketsRepository;
import pay2park.repositories.VehicleTypeRepository;

import java.util.*;

@Service
public class CheckInServiceImpl implements CheckInService{
    @Autowired
    ParkingLotRepository parkingLotRepository;
    @Autowired
    EndUserRepository endUserRepository;
    @Autowired
    VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    TicketsRepository ticketsRepository;
    @Autowired
    TicketService ticketService;
    public Map<String, Object> checkIn(Map<String, Object> checkInData) {
        Map<String, Object> ticket = new HashMap<>();
        Map<String, Object> informationData = getInformationCheckInData();
        if(!checkCheckInData(checkInData)) return ticket;
        if(!checkInformationCheckIn(informationData)) return ticket;
        List<Ticket> ticketsIsCreated = getTicketIsCreated(checkInData);
        if(ticketsIsCreated.size() > 0) {
            Ticket ticketIsCreated = ticketsIsCreated.get(0);
            ticket = new HashMap<>() {{
                put("ticketID", ticketIsCreated.getId());
                put("checkInTime", ticketIsCreated.getCheckInTime());
                put("licensePlate", ticketIsCreated.getLicensePlates());
                put("vehicleType", ticketIsCreated.getVehicleType());
                put("endUserID", ticketIsCreated.getEndUser().getId());
                put("parkingLotID", ticketIsCreated.getParkingLot().getId());
                put("parkingLotName", ticketIsCreated.getParkingLot().getParkingLotName());
                put("status", "Chưa thanh toán");
            }};
        } else {
            ticket = ticketService.createTicket(new TicketData(
                    String.valueOf(informationData.get("licensePlate")),
                    Long.parseLong(String.valueOf(informationData.get("vehicleTypeID"))),
                    Long.parseLong(String.valueOf(checkInData.get("endUserID"))),
                    Long.parseLong(String.valueOf(checkInData.get("parkingLotID")))));
        }
        return ticket;
    }
    private boolean checkCheckInData(Map<String, Object> checkInData) {
        boolean checkEndUserID = endUserRepository.existsById(Long.parseLong(String.valueOf(checkInData.get("endUserID"))));
        boolean checkParkingLotID = parkingLotRepository.existsById(Long.parseLong(String.valueOf(checkInData.get("parkingLotID"))));
        return checkEndUserID && checkParkingLotID;
    }
    private boolean checkInformationCheckIn(Map<String, Object> informationCheckInData) {
        boolean checkVehicleType = vehicleTypeRepository.existsById(Long.parseLong(String.valueOf(informationCheckInData.get("vehicleTypeID"))));
        boolean checkLicensePlate = informationCheckInData.get("licensePlate").toString().length() != 0;
        return checkLicensePlate && checkVehicleType;
    }
    private Map<String, Object> getInformationCheckInData() {
        return new HashMap<>() {{
            put("vehicleTypeID", 1);
            put("licensePlate", "77C1-67567");
        }};
    }
    private List<Ticket> getTicketIsCreated(Map<String, Object> checkInData) {
        Optional<EndUser> endUser = endUserRepository.findById(
                Long.parseLong(String.valueOf(checkInData.get("endUserID"))));
        Optional<ParkingLot> parkingLot = parkingLotRepository.findById(
                Long.parseLong(String.valueOf(checkInData.get("parkingLotID"))));
        return ticketsRepository.getTicketByEndUserIDAndParkingLot(endUser.get(), parkingLot.get());
    }
}
