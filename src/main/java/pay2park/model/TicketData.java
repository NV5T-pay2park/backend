package pay2park.model;

public class TicketData {
    private String licensePlate;
    private Long vehicleType;
    private Long endUserID;
    private Long parkingLotID;

    public TicketData() {
    }

    public TicketData(String licensePlate, Long vehicleType, Long ennUserID, Long parkingLotID) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.endUserID = ennUserID;
        this.parkingLotID = parkingLotID;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Long getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Long vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getEndUserID() {
        return endUserID;
    }

    public void setEndUserID(Long endUserID) {
        this.endUserID = endUserID;
    }

    public Long getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(Long parkingLotID) {
        this.parkingLotID = parkingLotID;
    }
}
