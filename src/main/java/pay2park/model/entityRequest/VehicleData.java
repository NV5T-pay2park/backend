package pay2park.model.entityRequest;

public class VehicleData {
    int vehicleTypeID;
    String licensePlate;

    public VehicleData(int vehicleTypeID, String licensePlate) {
        this.vehicleTypeID = vehicleTypeID;
        this.licensePlate = licensePlate;
    }

    public VehicleData() {
    }

    public int getVehicleTypeID() {
        return vehicleTypeID;
    }

    public void setVehicleTypeID(int vehicleTypeID) {
        this.vehicleTypeID = vehicleTypeID;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
