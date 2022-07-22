package pay2park.model.parking;

import pay2park.model.entityFromDB.ParkingLot;

public class ParkingListData {

    private Integer id;
    private String parkingLotName;
    private Double lat;
    private Double ing;
    private Integer timeOpen;
    private Integer timeClose;
    private Integer status;

    public ParkingListData(Integer id, String parkingLotName, Double lat, Double ing, Integer timeOpen, Integer timeClose, Integer status) {
        this.id = id;
        this.parkingLotName = parkingLotName;
        this.lat = lat;
        this.ing = ing;
        this.timeOpen = timeOpen;
        this.timeClose = timeClose;
        this.status = status;
    }
    public ParkingListData(ParkingLot parkingLot){
        this.id = parkingLot.getId();
        this.parkingLotName = parkingLot.getParkingLotName();
        this.lat = parkingLot.getLat();
        this.ing = parkingLot.getIng();
        this.timeOpen = parkingLot.getTimeOpen();
        this.timeClose = parkingLot.getTimeClose();
        this.status = parkingLot.getStatus();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getIng() {
        return ing;
    }

    public void setIng(Double ing) {
        this.ing = ing;
    }

    public Integer getTimeOpen() {
        return timeOpen;
    }

    public void setTimeOpen(Integer timeOpen) {
        this.timeOpen = timeOpen;
    }

    public Integer getTimeClose() {
        return timeClose;
    }

    public void setTimeClose(Integer timeClose) {
        this.timeClose = timeClose;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}