package pay2park.model.parking;

import pay2park.model.entityFromDB.ParkingLot;

import java.util.List;

public class ParkingDetailData {
    private Integer id;
    private String parkingLotName;
    private String address;
    private Integer status;
    private Double lat;
    private Double ing;
    private Integer timeOpen;
    private Integer timeClose;
    private List<PriceTicketData> priceTicketList;

    public ParkingDetailData(Integer id, String parkingLotName, String address, Integer status, Double lat, Double ing, Integer timeOpen, Integer timeClose, List<PriceTicketData> priceTicketList) {
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

    public ParkingDetailData(ParkingLot parkingLot, List<PriceTicketData> priceTicketDataList){
        this.id = parkingLot.getId();
        this.parkingLotName = parkingLot.getParkingLotName();
        this.address = parkingLot.getAddress();
        this.status = parkingLot.getStatus();
        this.lat = parkingLot.getLat();
        this.ing = parkingLot.getIng();
        this.timeOpen = parkingLot.getTimeOpen();
        this.timeClose = parkingLot.getTimeClose();
        this.priceTicketList = priceTicketList;
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