package pay2park.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pay2park.extension.Extension;
import pay2park.model.*;
import pay2park.repositories.EndUserRepository;
import pay2park.repositories.ParkingLotRepository;
import pay2park.repositories.TicketsRepository;
import pay2park.repositories.VehicleTypeRepository;

import java.time.Instant;
import java.util.*;

import static org.apache.http.client.methods.RequestBuilder.put;

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
    public Map<String, Object> createTicket(TicketData ticketData) {
        if(!checkTicketData(ticketData)) return null;
        Long id = createTicketID(ticketData);
        Instant checkInTime = getCheckInTime();
        String licensePlate = ticketData.getLicensePlate();
        Long vehicleTypeID = ticketData.getVehicleType();
        Optional<VehicleType> vehicleType = vehicleTypeRepository.findById(vehicleTypeID);
        Long endUserID = ticketData.getEndUserID();
        Optional<EndUser> endUser = endUserRepository.findById(endUserID);
        Long parkingLotID = ticketData.getParkingLotID();
        Optional<ParkingLot> parkingLot = parkingLotRepository.findById(parkingLotID);
        String parkingLotName = parkingLotRepository.findById(parkingLotID).get().getParkingLotName();
        String vehicleTypeName = vehicleTypeRepository.findById(ticketData.getVehicleType()).get().getVehicleTypeName();
        String status = "Chưa thanh toán";
        Ticket ticket = new Ticket(id, checkInTime, null,
                licensePlate, vehicleType.get(), endUser.get(), parkingLot.get());
//        ticket.setId(id);
//        ticket.setCheckInTime(checkInTime);
//        ticket.setCheckOutTime(checkInTime);
//        ticket.setLicensePlates(licensePlate);
//        ticket.setVehicleType(vehicleType.get());
//        ticket.setEndUser(endUser.get());
//        ticket.setParkingLot(parkingLot.get());
//        return ticket;
        ticketsRepository.save(ticket);
        return new HashMap<>() {{
            put("ticketID", id);
            put("checkInTime", checkInTime);
            put("licensePlate", licensePlate);
            put("vehicleType", vehicleTypeName);
            put("endUserID", endUserID);
            put("parkingLotID", parkingLotID);
            put("parkingLotName", parkingLotName);
            put("status", status);
        }};
    }

    @Override
    public List<Ticket> getTicketByEndUserId(Long endUserID) {
        if(!endUserRepository.existsById(endUserID)) return new ArrayList<>();
        Optional<EndUser> endUser = endUserRepository.findById(endUserID);
        return ticketsRepository.getAllTicketByEndUserID(endUser.get());
    }

    private Long createTicketID(TicketData ticketData) {
        String createTicketTime = Extension.getCurrentTimeString("yyMMddHHmmss");
        String parkingLotID = ticketData.getParkingLotID().toString();
        String endUserID = String.valueOf(ticketData.getEndUserID().toString());
        return Long.valueOf(createTicketTime + parkingLotID + endUserID);
    }

    private boolean checkTicketData(TicketData ticketData) {
        boolean checkEndUserID = endUserRepository.existsById(ticketData.getEndUserID());
        boolean checkParkingLotID = parkingLotRepository.existsById(ticketData.getParkingLotID());
        boolean checkVehicleType = vehicleTypeRepository.existsById(ticketData.getVehicleType());
        boolean checkLicense = ticketData.getLicensePlate().length() != 0;
        return checkParkingLotID && checkEndUserID && checkVehicleType && checkLicense;
    }
    private Instant getCheckInTime() {
        String time = Extension.getCurrentTimeString("yyyy-MM-dd") + 'T' +
                Extension.getCurrentTimeString("HH:mm:ss") + 'Z';
        return Instant.parse(time);
    }
    @Override
    public List<Ticket> test() {
        return ticketsRepository.findAll();
    }
}