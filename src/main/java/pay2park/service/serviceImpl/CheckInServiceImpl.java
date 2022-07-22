package pay2park.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pay2park.model.entityFromDB.EndUser;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.Ticket;
import pay2park.model.entityRequest.CheckInData;
import pay2park.model.entityRequest.VehicleData;
import pay2park.model.entityResponse.ResponseObject;
import pay2park.model.entityRequest.TicketData;
import pay2park.model.entityResponse.ResponseTicketData;
import pay2park.repositories.EndUserRepository;
import pay2park.repositories.ParkingLotRepository;
import pay2park.repositories.TicketsRepository;
import pay2park.repositories.VehicleTypeRepository;
import pay2park.service.serviceInterface.CheckInService;
import pay2park.service.serviceInterface.TicketService;

import java.util.*;

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
    public ResponseObject checkIn(CheckInData checkInData) {
        ResponseTicketData ticket = new ResponseTicketData();
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
            ticket = new ResponseTicketData(ticketIsCreated.getId(), ticketIsCreated.getCheckInTime(),
                    ticketIsCreated.getLicensePlates(), ticketIsCreated.getVehicleType().getVehicleTypeName(),
                    ticketIsCreated.getEndUser().getId(),
                    ticketIsCreated.getEndUser().getFirstName() + ' ' + ticketIsCreated.getEndUser().getLastName(),
                    ticketIsCreated.getParkingLot().getId(), ticketIsCreated.getParkingLot().getParkingLotName(),
                    "Chưa thanh toán");
            return new ResponseObject(HttpStatus.BAD_REQUEST, "Ticket is created", ticket);
        } else {
            ticket = ticketService.createTicket(
                    new TicketData(informationData.getLicensePlate(),
                            informationData.getVehicleTypeID(),
                            checkInData.getEndUserID(),
                            checkInData.getParkingLotID()));
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