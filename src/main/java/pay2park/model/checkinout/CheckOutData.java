package pay2park.model.checkinout;

public class CheckOutData {
    Long ticketID;
    int endUserID;
    int parkingLotID;
    String licensePlate;

    public CheckOutData() {
    }

    public CheckOutData(Long ticketID, int endUserID, int parkingLotID, String licensePlate) {
        this.ticketID = ticketID;
        this.endUserID = endUserID;
        this.parkingLotID = parkingLotID;
        this.licensePlate = licensePlate;
    }

    public Long getTicketID() {
        return ticketID;
    }

    public void setTicketID(Long ticketID) {
        this.ticketID = ticketID;
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

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
