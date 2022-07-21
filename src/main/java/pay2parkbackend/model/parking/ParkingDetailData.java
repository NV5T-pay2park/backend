package pay2parkbackend.model.parking;

import pay2parkbackend.model.entityFromDB.Merchant;
import pay2parkbackend.model.entityFromDB.PriceTicket;

import javax.persistence.*;
import java.util.List;

public class ParkingDetailData {
    private Long id;
    private String parkingLotName;
    private String address;
    private Integer status;
    private Double lat;
    private Double ing;
    private Integer timeOpen;
    private Integer timeClose;
    private List<PriceTicketData> priceTicketList;

    public ParkingDetailData(Long id, String parkingLotName, String address, Integer status, Double lat, Double ing, Integer timeOpen, Integer timeClose, List<PriceTicketData> priceTicketList) {
        this.id = id;
        this.parkingLotName = parkingLotName;
        this.address = address;
        this.status = status;
        this.lat = lat;
        this.ing = ing;
        this.timeOpen = timeOpen;
        this.timeClose = timeClose;
        this.priceTicketList = priceTicketList;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public List<PriceTicketData> getPriceTicketList() {
        return priceTicketList;
    }

    public void setPriceTicketList(List<PriceTicketData> priceTicketList) {
        this.priceTicketList = priceTicketList;
    }
}
