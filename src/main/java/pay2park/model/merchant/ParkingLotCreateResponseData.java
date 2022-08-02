package pay2park.model.merchant;

public class ParkingLotCreateResponseData {
    public boolean code;
    private String message;
    public int parkingLotId;

    public ParkingLotCreateResponseData(boolean code, String message, int parkingLotId) {
        this.code = code;
        this.message = message;
        this.parkingLotId = parkingLotId;
    }

    public ParkingLotCreateResponseData(boolean code, String message) {
        this.code = code;
        this.message = message;
    }

    public String mess() {
        return message;
    }
}
