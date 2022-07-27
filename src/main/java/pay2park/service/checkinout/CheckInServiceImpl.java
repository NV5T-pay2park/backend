package pay2park.service.checkinout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pay2park.model.ResponseObject;
import pay2park.model.checkinout.CheckInData;
import pay2park.model.entityFromDB.EndUser;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.Ticket;
import pay2park.model.parking.VehicleData;
import pay2park.model.ticket.TicketData;
import pay2park.model.ticket.ResponseTicketData;
import pay2park.repository.EndUserRepository;
import pay2park.repository.ParkingLotRepository;
import pay2park.repository.TicketsRepository;
import pay2park.repository.VehicleTypeRepository;
import pay2park.service.ticket.TicketService;
import pay2park.service.websocket.Socket;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class CheckInServiceImpl implements CheckInService {
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
    @Autowired
    Socket socket;
    public ResponseObject checkIn(CheckInData checkInData) {
        ResponseTicketData ticket = new ResponseTicketData();
        // send to merchant to enter license plate
        socket.SendCheckInSuccessful(checkInData.getParkingLotID());
        // wait for merchant send cense plate
        VehicleData informationData = getInformationCheckInDataMock();
        if(!checkCheckInData(checkInData)) {
            return new ResponseObject(HttpStatus.FOUND, "Data is not valid", ticket);
        }
        if(!checkInformationCheckIn(informationData)) {
            return new ResponseObject(HttpStatus.FOUND, "Data is not valid", ticket);
        }
        List<Ticket> ticketsIsCreated = getTicketIsCreated(checkInData);
        if(ticketsIsCreated.size() > 0) {
            Ticket ticketIsCreated = ticketsIsCreated.get(0);
            ticket = new ResponseTicketData(ticketIsCreated.getId(), ticketIsCreated.getCheckInTime(), null,
                    ticketIsCreated.getLicensePlates(), ticketIsCreated.getVehicleType().getVehicleTypeName(),
                    ticketIsCreated.getEndUser().getId(),
                    ticketIsCreated.getEndUser().getFirstName() + ' ' + ticketIsCreated.getEndUser().getLastName(),
                    ticketIsCreated.getParkingLot().getId(), ticketIsCreated.getParkingLot().getParkingLotName(), false);
            socket.SendCheckInFail(checkInData.getParkingLotID());
            return new ResponseObject(HttpStatus.BAD_REQUEST, "Ticket is created", ticket);
        } else {
            ticket = ticketService.createTicket(
                    new TicketData(informationData.getLicensePlate(),
                            informationData.getVehicleTypeID(),
                            checkInData.getEndUserID(),
                            checkInData.getParkingLotID()));
            socket.SendCheckInSuccessful(checkInData.getParkingLotID());
            return new ResponseObject(HttpStatus.OK, "Success", ticket);
        }
    }
    private boolean checkCheckInData(CheckInData checkInData) {
        boolean checkEndUserID = endUserRepository.
                existsById(checkInData.getEndUserID());
        boolean checkParkingLotID = parkingLotRepository.
                existsById(checkInData.getParkingLotID());
        return checkEndUserID && checkParkingLotID;
    }
    private boolean checkInformationCheckIn(VehicleData informationCheckInData) {
        boolean checkVehicleType = vehicleTypeRepository.
                existsById(informationCheckInData.getVehicleTypeID());
        boolean checkLicensePlate = informationCheckInData.getLicensePlate().length() != 0;
        return checkLicensePlate && checkVehicleType;
    }
    @Override
    public ResponseObject getInformationCheckInData(VehicleData informationCheckInData) {
        if (checkInformationCheckInData(informationCheckInData)) {
            return new ResponseObject(HttpStatus.OK, "Success", informationCheckInData);
        }
        return new ResponseObject(HttpStatus.FOUND, "Found", new VehicleData());
    }
    private boolean checkInformationCheckInData(VehicleData vehicleData) {
        boolean checkVehicleType = vehicleTypeRepository.existsById(vehicleData.getVehicleTypeID());
        boolean checkLicensePlate = vehicleData.getLicensePlate().length() > 0;
        return checkLicensePlate && checkVehicleType;
    }
    private List<Ticket> getTicketIsCreated(CheckInData checkInData) {
        Optional<EndUser> endUser = endUserRepository.findById(checkInData.getEndUserID());
        Optional<ParkingLot> parkingLot = parkingLotRepository.findById(checkInData.getParkingLotID());
        return ticketsRepository.getTicketByEndUserIDAndParkingLot(endUser.get(), parkingLot.get());
    }
    private VehicleData getInformationCheckInDataMock() {
        return new VehicleData(1, "77C1-67567");
    }
}