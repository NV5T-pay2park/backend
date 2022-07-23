package pay2park.model.parking;

import pay2park.model.entityFromDB.ParkingLot;

public class ParkingListData {

    private Integer id;
    private String parkingLotName;
    private Integer timeOpen;
    private Integer timeClose;
    private Integer status;
    private String phoneNumber;
    private Double distance;
    private Integer timeMoving;


    public ParkingListData(Integer id, String parkingLotName, Integer timeOpen, Integer timeClose, Integer status, String phoneNumber, Double distance , Integer timeMoving) {
        this.id = id;
        this.parkingLotName = parkingLotName;
        this.timeOpen = timeOpen;
        this.timeClose = timeClose;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.distance = distance;
        this.timeMoving = timeMoving;
    }
    public ParkingListData(ParkingLot parkingLot, Double distance, Integer timeMoving){
        this.id = parkingLot.getId();
        this.parkingLotName = parkingLot.getParkingLotName();
        this.timeOpen = parkingLot.getTimeOpen();
        this.timeClose = parkingLot.getTimeClose();
        this.status = parkingLot.getStatus();
        this.phoneNumber = parkingLot.getPhoneNumber();
        this.distance = distance;
        this.timeMoving = timeMoving;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getTimeMoving() {
        return timeMoving;
    }

    public void setTimeMoving(Integer timeMoving) {
        this.timeMoving = timeMoving;
    }
}