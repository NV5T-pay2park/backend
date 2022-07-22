package pay2parkbackend.model.parking;

import pay2parkbackend.model.entityFromDB.Merchant;
import pay2parkbackend.model.entityFromDB.ParkingLot;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ParkingListData {

    private Long id;
    private String parkingLotName;
    private Double lat;
    private Double ing;
    private Integer timeOpen;
    private Integer timeClose;
    private Integer status;

    public ParkingListData(Long id, String parkingLotName, Double lat, Double ing, Integer timeOpen, Integer timeClose, Integer status) {
        this.id = id;
        this.parkingLotName = parkingLotName;
        this.lat = lat;
        this.ing = ing;
        this.timeOpen = timeOpen;
        this.timeClose = timeClose;
        this.status = status;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
