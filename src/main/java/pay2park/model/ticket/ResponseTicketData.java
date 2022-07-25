package pay2park.model.ticket;

import java.time.Instant;
import java.util.Date;

public class ResponseTicketData {
    private Long ticketID;
    private Instant checkInTime;
    Integer amount;
    private String licensePlate;
    private String vehicleType;
    private int endUserID;
    private String endUserName;
    private int parkingLotID;
    private String parkingLotName;
    private boolean status;

    public ResponseTicketData() {

    }

    public ResponseTicketData(Long ticketID, Instant checkInTime, Integer amount, String licensePlate, String vehicleType,
                              int endUserID, String endUserName, int parkingLotID, String parkingLotName, boolean status) {
        this.ticketID = ticketID;
        this.checkInTime = checkInTime;
        this.amount = amount;
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.endUserID = endUserID;
        this.endUserName = endUserName;
        this.parkingLotID = parkingLotID;
        this.parkingLotName = parkingLotName;
        this.status = status;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public boolean isStatus() {
        return status;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
