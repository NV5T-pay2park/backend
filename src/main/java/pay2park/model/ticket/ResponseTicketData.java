package pay2park.model.ticket;

import pay2park.extension.Extension;
import pay2park.model.entityFromDB.Ticket;

public class ResponseTicketData {
    private Long ticketID;
    private String checkInTime;
    private String checkOutTime;
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

    public ResponseTicketData(Long ticketID, String checkInTime, String checkOutTime,
                              String licensePlate, String vehicleType, int endUserID, String endUserName,
                              int parkingLotID, String parkingLotName, boolean status , Integer amount) {
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
        this.checkInTime = Extension.formatTime(ticket.getCheckInTime());
        this.checkOutTime = Extension.formatTime(ticket.getCheckOutTime());
        this.licensePlate = ticket.getLicensePlates();
        this.vehicleType = ticket.getVehicleType().getVehicleTypeName();
        this.endUserID = ticket.getEndUser().getId();
        this.endUserName = ticket.getEndUser().getFirstName() + " " + ticket.getEndUser().getLastName();
        this.parkingLotID = ticket.getParkingLot().getId();
        this.parkingLotName = ticket.getParkingLot().getParkingLotName();
        this.status = ticket.getCheckOutTime() != null;
        this.amount = ticket.getAmount();
    }


    public Long getTicketID() {
        return ticketID;
    }

    public void setTicketID(Long ticketID) {
        this.ticketID = ticketID;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
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
