package pay2park.service.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pay2park.extension.Extension;
import pay2park.model.ResponseObject;
import pay2park.model.entityFromDB.EndUser;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.Ticket;
import pay2park.model.entityFromDB.VehicleType;
import pay2park.model.ticket.TicketData;
import pay2park.model.ticket.ResponseTicketData;
import pay2park.repository.EndUserRepository;
import pay2park.repository.ParkingLotRepository;
import pay2park.repository.TicketsRepository;
import pay2park.repository.VehicleTypeRepository;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;


import static pay2park.extension.Extension.getCheckInTime;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketsRepository ticketsRepository;
    @Autowired
    private EndUserRepository endUserRepository;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    private ParkingLotRepository parkingLotRepository;
    @Override
    public ResponseTicketData createTicket(TicketData ticketData) {
        if(!checkTicketData(ticketData)) return null;
        Long id = createTicketID(ticketData);
        Instant checkInTime = getCheckInTime();
        Integer amount = null;
        String licensePlate = ticketData.getLicensePlate();
        int vehicleTypeID = ticketData.getVehicleType();
        Optional<VehicleType> vehicleType = vehicleTypeRepository.findById(vehicleTypeID);
        int endUserID = ticketData.getEndUserID();
        Optional<EndUser> endUser = endUserRepository.findById(endUserID);
        int parkingLotID = ticketData.getParkingLotID();
        Optional<ParkingLot> parkingLot = parkingLotRepository.findById(parkingLotID);
        String parkingLotName = parkingLotRepository.findById(parkingLotID).get().getParkingLotName();
        String vehicleTypeName = vehicleTypeRepository.findById(ticketData.getVehicleType()).get().getVehicleTypeName();
        Ticket ticket = new Ticket(id, checkInTime, null,
                licensePlate, vehicleType.get(), endUser.get(), parkingLot.get());
        try {
            ticketsRepository.save(ticket);
            return new ResponseTicketData(id, checkInTime, amount, licensePlate, vehicleTypeName, endUserID,
                    endUser.get().getFirstName() + ' ' + endUser.get().getLastName(),
                    parkingLotID, parkingLotName, false);
        } catch (Exception e) {
            return new ResponseTicketData();
        }
    }
    @Override
    public ResponseObject getTicketByEndUserId(int endUserID) {
        if(!endUserRepository.existsById(endUserID)) {
            return new ResponseObject(HttpStatus.FOUND, "End user is not valid",
                    new ArrayList<Ticket>());
        }
        Optional<EndUser> endUser = endUserRepository.findById(endUserID);
        List<Ticket> ticketByEndUserID = ticketsRepository.getAllTicketByEndUserID(endUser.get());
        List<ResponseTicketData> dataResponse = ticketByEndUserID.stream().map(
                i -> new ResponseTicketData(i.getId(), i.getCheckInTime(),
                        (i.getCheckOutTime() == null) ? null : calculateAmount(i.getId()),i.getLicensePlates(),
                        i.getVehicleType().getVehicleTypeName(),
                        i.getEndUser().getId(),
                        i.getEndUser().getFirstName() + ' ' + i.getEndUser().getLastName(),
                        i.getParkingLot().getId(), i.getParkingLot().getParkingLotName(),
                        !(i.getCheckOutTime() == null))).collect(Collectors.toList());
        return new ResponseObject(HttpStatus.OK, "Success", dataResponse);
    }
    private Integer calculateAmount(Long ticketID) {
        return 5000;
    }
    private Long createTicketID(TicketData ticketData) {
        String createTicketTime = Extension.getCurrentTimeString("yyMMddHHmmss");
        String parkingLotID = String.valueOf(ticketData.getParkingLotID());
        String endUserID = String.valueOf(ticketData.getEndUserID());
        return Long.valueOf(createTicketTime + parkingLotID + endUserID);
    }

    private boolean checkTicketData(TicketData ticketData) {
        boolean checkEndUserID = endUserRepository.existsById(ticketData.getEndUserID());
        boolean checkParkingLotID = parkingLotRepository.existsById(ticketData.getParkingLotID());
        boolean checkVehicleType = vehicleTypeRepository.existsById(ticketData.getVehicleType());
        boolean checkLicense = ticketData.getLicensePlate().length() != 0;
        return checkParkingLotID && checkEndUserID && checkVehicleType && checkLicense;
    }
}