package pay2park.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pay2park.extension.Extension;
import pay2park.model.entityFromDB.EndUser;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.Ticket;
import pay2park.model.entityFromDB.VehicleType;
import pay2park.model.entityResponse.ResponseObject;
import pay2park.model.entityRequest.TicketData;
import pay2park.model.entityResponse.ResponseTicketData;
import pay2park.repositories.EndUserRepository;
import pay2park.repositories.ParkingLotRepository;
import pay2park.repositories.TicketsRepository;
import pay2park.repositories.VehicleTypeRepository;
import pay2park.service.serviceInterface.TicketService;

import java.time.Instant;
import java.util.*;

import static org.apache.http.client.methods.RequestBuilder.put;
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
        String licensePlate = ticketData.getLicensePlate();
        int vehicleTypeID = ticketData.getVehicleType();
        Optional<VehicleType> vehicleType = vehicleTypeRepository.findById(vehicleTypeID);
        int endUserID = ticketData.getEndUserID();
        Optional<EndUser> endUser = endUserRepository.findById(endUserID);
        int parkingLotID = ticketData.getParkingLotID();
        Optional<ParkingLot> parkingLot = parkingLotRepository.findById(parkingLotID);
        String parkingLotName = parkingLotRepository.findById(parkingLotID).get().getParkingLotName();
        String vehicleTypeName = vehicleTypeRepository.findById(ticketData.getVehicleType()).get().getVehicleTypeName();
        String status = "Chưa thanh toán";
        Ticket ticket = new Ticket(id, checkInTime, null,
                licensePlate, vehicleType.get(), endUser.get(), parkingLot.get());
        try {
            ticketsRepository.save(ticket);
            return new ResponseTicketData(id, checkInTime, licensePlate, vehicleTypeName, endUserID,
                    "enduserName", parkingLotID, parkingLotName, status);
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
        return new ResponseObject(HttpStatus.OK, "Success",
                ticketsRepository.getAllTicketByEndUserID(endUser.get()));
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