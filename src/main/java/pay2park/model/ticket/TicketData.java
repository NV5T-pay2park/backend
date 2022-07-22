package pay2park.model.ticket;

public class TicketData {
    private String licensePlate;
    private int vehicleType;
    private int endUserID;
    private int parkingLotID;

    public TicketData() {
    }

    public TicketData(String licensePlate, int vehicleType, int ennUserID, int parkingLotID) {
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

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getEndUserID() {
        return endUserID;
    }

    public void setEndUserID(int endUserID) {
        this.endUserID = endUserID;
    }

    public int getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(int parkingLotID) {
        this.parkingLotID = parkingLotID;
    }
}
