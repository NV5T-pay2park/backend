package pay2park.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pay2park.extension.Extension;
import pay2park.model.entityRequest.CheckOutData;
import pay2park.model.entityResponse.ResponseObject;
import pay2park.model.entityFromDB.EndUser;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.Ticket;
import pay2park.repositories.EndUserRepository;
import pay2park.repositories.ParkingLotRepository;
import pay2park.repositories.TicketsRepository;
import pay2park.service.serviceInterface.CheckOutService;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CheckOutServiceImpl implements CheckOutService {
    @Autowired
    EndUserRepository endUserRepository;
    @Autowired
    TicketsRepository ticketsRepository;
    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Override
    public ResponseObject checkOut(CheckOutData checkOutData) {
        if (!checkDataIsValid(checkOutData)) {
            return new ResponseObject(HttpStatus.FOUND, "Data is not valid", "");
        }
        if (!checkTicketIsValid(checkOutData)) {
            return new ResponseObject(HttpStatus.FOUND, "Ticket is not valid", "");
        }
        Long ticketID = checkOutData.getTicketID();
        Instant checkOutTime = Extension.getCheckInTime();
//        ticketsRepository.updateTicket(checkOutTime, ticketID);
        // thanh toan zalopay
        // for vũ đẹp trai
        return new ResponseObject(HttpStatus.OK, "", "");
    }

    private boolean checkDataIsValid(CheckOutData checkOutData) {
        boolean checkTicketIsExist = ticketsRepository.
                existsById(checkOutData.getTicketID());
        boolean checkEndUserIDIsExist = endUserRepository.
                existsById(checkOutData.getEndUserID());
        boolean checkParkingLotIDIsExist = parkingLotRepository.
                existsById(checkOutData.getParkingLotID());
        boolean checkLicensePlateIsValid = checkOutData.getLicensePlate().length() > 0;
        return checkEndUserIDIsExist && checkTicketIsExist && checkParkingLotIDIsExist && checkLicensePlateIsValid;
    }

    private boolean checkTicketIsValid(CheckOutData checkOutData) {
        Optional<EndUser> endUser = endUserRepository.
                findById(checkOutData.getEndUserID());
        Optional<ParkingLot> parkingLot = parkingLotRepository.
                findById(checkOutData.getParkingLotID());
        List<Ticket> tickets = ticketsRepository.getTicketByEndUserIDAndParkingLot(endUser.get(), parkingLot.get());
        if (tickets.size() == 0) return false;
        Ticket ticket = tickets.get(0);
        return Objects.equals(ticket.getLicensePlates(), checkOutData.getLicensePlate());
    }
}
