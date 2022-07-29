package pay2park.model.parking;

import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.ParkingLotImage;

public class ParkingMerchantListData {

    public Integer id;
    public String name;
    public Integer timeOpen;
    public Integer timeClose;
    public Integer currentServing;
    public String address;
    public String phone;
    public Integer status;
    public String image;

    public ParkingMerchantListData(ParkingLot parkingLot, ParkingLotImage parkingLotImage) {
        this.id = parkingLot.getId();
        this.name = parkingLot.getParkingLotName();
        this.timeOpen = parkingLot.getTimeOpen();
        this.timeClose = parkingLot.getTimeClose();
        this.currentServing = parkingLot.getNumberSlot() - parkingLot.getNumberSlotRemaining();
        this.address = parkingLot.getStreet() + ", " +  parkingLot.getWard() + ", " + parkingLot.getDistrict() + ", " + parkingLot.getCity();
        this.phone = parkingLot.getPhoneNumber();
        this.status = parkingLot.getStatus();
        this.image = parkingLotImage.getUrl();
    }

    public ParkingMerchantListData(ParkingLot parkingLot) {
        this.id = parkingLot.getId();
        this.name = parkingLot.getParkingLotName();
        this.timeOpen = parkingLot.getTimeOpen();
        this.timeClose = parkingLot.getTimeClose();
        this.currentServing = parkingLot.getNumberSlot() - parkingLot.getNumberSlotRemaining();
        this.address = parkingLot.getStreet() + ", " +  parkingLot.getWard() + ", " + parkingLot.getDistrict() + ", " + parkingLot.getCity();
        this.phone = parkingLot.getPhoneNumber();
        this.status = parkingLot.getStatus();
        this.image = null;

        System.out.println(this.id);
        System.out.println(this.name);
    }
}
