package pay2park.model.checkinout;

import pay2park.model.parking.VehicleData;

public class CheckInInformation {
    CheckInData checkInData;
    VehicleData vehicleData;

    public CheckInInformation(CheckInData checkInData, VehicleData vehicleData) {
        this.checkInData = checkInData;
        this.vehicleData = vehicleData;
    }

    public CheckInData getCheckInData() {
        return checkInData;
    }

    public VehicleData getVehicleData() {
        return vehicleData;
    }

    public void setCheckInData(CheckInData checkInData) {
        this.checkInData = checkInData;
    }

    public void setVehicleData(VehicleData vehicleData) {
        this.vehicleData = vehicleData;
    }
}
