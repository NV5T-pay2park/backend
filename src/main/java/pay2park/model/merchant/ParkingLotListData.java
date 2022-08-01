package pay2park.model.merchant;

import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.ParkingLotImage;

public class ParkingLotListData {
    public Integer id;
    public String name;
    public String timeOpen;
    public String timeClose;
    public Integer currentServing;
    public String address;
    public String phoneNumber;
    public Integer status;
    public String image;

    public ParkingLotListData(ParkingLot parkingLot, ParkingLotImage parkingLotImage) {
        this.id = parkingLot.getId();
        this.name = parkingLot.getParkingLotName();
        this.timeOpen = parkingLot.getTimeOpen();
        this.timeClose = parkingLot.getTimeClose();
        this.currentServing = parkingLot.getNumberSlot() - parkingLot.getNumberSlotRemaining();
        this.address = parkingLot.getStreet() + ", " +  parkingLot.getWard() + ", " + parkingLot.getDistrict() + ", " + parkingLot.getCity();
        this.phoneNumber = parkingLot.getPhoneNumber();
        this.status = parkingLot.getStatus();
        this.image = parkingLotImage.getUrl();
    }

    public ParkingLotListData(ParkingLot parkingLot) {
        this.id = parkingLot.getId();
        this.name = parkingLot.getParkingLotName();
        this.timeOpen = parkingLot.getTimeOpen();
        this.timeClose = parkingLot.getTimeClose();
        this.currentServing = parkingLot.getNumberSlot() - parkingLot.getNumberSlotRemaining();
        this.address = parkingLot.getStreet() + ", " +  parkingLot.getWard() + ", " + parkingLot.getDistrict() + ", " + parkingLot.getCity();
        this.phoneNumber = parkingLot.getPhoneNumber();
        this.status = parkingLot.getStatus();
        this.image = null;
    }
}
