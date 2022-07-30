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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CheckInData other = (CheckInData) obj;
        if (endUserID != other.endUserID)
            return false;
        return parkingLotID == other.parkingLotID;
    }

    @Override
    public int hashCode() {
        return endUserID * parkingLotID;
    }
}
