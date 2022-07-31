package pay2park.model.ticket;

import pay2park.model.entityFromDB.Ticket;

import java.time.Instant;
import java.util.Date;

public class ResponseTicketData {
    private Long ticketID;
    private Instant checkInTime;
    private Instant checkOutTime;
    private String licensePlate;
    private String vehicleType;
    private int endUserID;
    private String endUserName;
    private int parkingLotID;
    private String parkingLotName;
    private boolean status;
    private Integer amount;
    public ResponseTicketData() {

    }

    public ResponseTicketData(Long ticketID, Instant checkInTime, Instant checkOutTime,
                              String licensePlate, String vehicleType, int endUserID, String endUserName, int parkingLotID, String parkingLotName, boolean status , Integer amount) {
        this.ticketID = ticketID;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.endUserID = endUserID;
        this.endUserName = endUserName;
        this.parkingLotID = parkingLotID;
        this.parkingLotName = parkingLotName;
        this.status = status;
        this.amount = amount;
    }
    public ResponseTicketData(Ticket ticket){
        this.ticketID = ticket.getId();
        this.checkInTime = ticket.getCheckInTime();
        this.checkOutTime = ticket.getCheckOutTime();
        this.licensePlate = ticket.getLicensePlates();
        this.vehicleType = ticket.getVehicleType().getVehicleTypeName();
        this.endUserID = ticket.getEndUser().getId();
        this.endUserName = ticket.getEndUser().getFirstName() + " " + ticket.getEndUser().getLastName();
        this.parkingLotID = ticket.getParkingLot().getId();
        this.parkingLotName = ticket.getParkingLot().getParkingLotName();
        this.status = ticket.getCheckOutTime() != null ? true: false;
        this.amount = ticket.getAmount();
    }


    public Long getTicketID() {
        return ticketID;
    }

    public void setTicketID(Long ticketID) {
        this.ticketID = ticketID;
    }

    public Instant getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Instant checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Instant getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Instant checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getEndUserID() {
        return endUserID;
    }

    public void setEndUserID(int endUserID) {
        this.endUserID = endUserID;
    }

    public String getEndUserName() {
        return endUserName;
    }

    public void setEndUserName(String endUserName) {
        this.endUserName = endUserName;
    }

    public int getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(int parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
