package pay2park.model.checkinout;

public class CheckInData {
    int endUserID;
    int parkingLotID;

    public CheckInData(int endUserID, int parkingLotID) {
        this.endUserID = endUserID;
        this.parkingLotID = parkingLotID;
    }

    public CheckInData() {
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
