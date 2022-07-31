package pay2park.service.checkinout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pay2park.extension.Extension;
import pay2park.model.ResponseObject;
import pay2park.model.checkinout.CheckInData;
import pay2park.model.entityFromDB.EndUser;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.Ticket;
import pay2park.model.parking.VehicleData;
import pay2park.model.ticket.TicketData;
import pay2park.model.ticket.ResponseTicketData;
import pay2park.repository.*;
import pay2park.service.ticket.TicketService;
import pay2park.service.websocket.Socket;

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
    @Autowired
    Socket socket;

    @Autowired
    PendingTicketRepository pendingTicketRepository;

    public ResponseObject checkIn(CheckInData checkInData) {
        ResponseTicketData ticket = new ResponseTicketData();
        if (!isValidNumberSlotRemaining(checkInData)) {
            return new ResponseObject(HttpStatus.FOUND, "Sold out", ticket);
        }
        if (!checkCheckInData(checkInData)) {
            return new ResponseObject(HttpStatus.FOUND, "Data is not valid", ticket);
        }

//        if (!pendingTicketRepository.addPendingTicket(checkInData)) {
//            return new ResponseObject(HttpStatus.FOUND, "This user already in queue", ticket);
//        }
//        socket.RequestToEnterLicensePlate(checkInData);
        VehicleData vehicleData = getInformationCheckInData(checkInData);

        if (!isValidInformationCheckIn(vehicleData)) {
            return new ResponseObject(HttpStatus.FOUND, "Data is not valid", ticket);
        }

        List<Ticket> ticketsIsCreated = getTicketIsCreated(checkInData, vehicleData);
        if (ticketsIsCreated.size() > 0) {
            Ticket ticketIsCreated = ticketsIsCreated.get(0);
            ticket = new ResponseTicketData(ticketIsCreated.getId(),
                    Extension.formatTime(ticketIsCreated.getCheckInTime()), null,
                    ticketIsCreated.getLicensePlates(), ticketIsCreated.getVehicleType().getVehicleTypeName(),
                    ticketIsCreated.getEndUser().getId(),
                    ticketIsCreated.getEndUser().getFirstName() + ' ' + ticketIsCreated.getEndUser().getLastName(),
                    ticketIsCreated.getParkingLot().getId(), ticketIsCreated.getParkingLot().getParkingLotName(), false, null);
            socket.SendCheckInFail(checkInData.getParkingLotID());
            return new ResponseObject(HttpStatus.BAD_REQUEST, "Ticket is created", ticket);
        } else {
            ticket = ticketService.createTicket(
                    new TicketData(vehicleData.getLicensePlate(),
                            vehicleData.getVehicleTypeID(),
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

    private boolean isValidInformationCheckIn(VehicleData vehicleData) {
        boolean checkVehicleType = vehicleTypeRepository.
                existsById(vehicleData.getVehicleTypeID());
        boolean checkLicensePlate = vehicleData.getLicensePlate().length() != 0;
        return checkLicensePlate && checkVehicleType;
    }



    private boolean isValidInformationCheckInData(VehicleData vehicleData) {
        boolean checkVehicleType = vehicleTypeRepository.existsById(vehicleData.getVehicleTypeID());
        boolean checkLicensePlate = vehicleData.getLicensePlate().length() > 0;
        return checkLicensePlate && checkVehicleType;
    }

    private List<Ticket> getTicketIsCreated(CheckInData checkInData, VehicleData vehicleData) {
        Optional<EndUser> endUser = endUserRepository.findById(checkInData.getEndUserID());
        Optional<ParkingLot> parkingLot = parkingLotRepository.findById(checkInData.getParkingLotID());
        return ticketsRepository.getTicketByEndUserIDAndParkingLot(endUser.get(), parkingLot.get(), vehicleData.getLicensePlate());
    }

    @Override
    public ResponseObject getInformationCheckInData(CheckInData checkInData,VehicleData vehicleData) {
        if (isValidInformationCheckInData(vehicleData)) {
            pendingTicketRepository.setPendingTicketInformation(checkInData, vehicleData);
            return new ResponseObject(HttpStatus.OK, "Success", vehicleData);
        }
        return new ResponseObject(HttpStatus.FOUND, "Found", "");
    }
    private VehicleData getInformationCheckInData(CheckInData checkInData) {
        return new VehicleData(1, "77C1-09876");
//        while (pendingTicketRepository.isPendingTicket(checkInData));
//        VehicleData result = pendingTicketRepository.getPendingTicketInformation(checkInData);
//        pendingTicketRepository.removePendingTicket(checkInData);
//        return result;
    }

    private boolean isValidNumberSlotRemaining(CheckInData checkInData) {
        Optional<ParkingLot> parkingLot = parkingLotRepository.findById(checkInData.getParkingLotID());
        return parkingLot.get().getNumberSlotRemaining() > 0;
    }
}