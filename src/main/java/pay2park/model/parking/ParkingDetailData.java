package pay2park.model.parking;

import pay2park.model.entityFromDB.ParkingLot;

import javax.persistence.Column;
import java.util.List;

public class ParkingDetailData {
    private Integer id;
    private String parkingLotName;
    private String street;
    private String ward;
    private String district;
    private String city;
    private Double lat;
    private Double ing;
    private Integer status;
    private Integer timeOpen;
    private Integer timeClose;
    private String phoneNumber;
    private Double distance;
    private Integer timeMoving;
    private List<PriceTicketData> priceTicketList;



    public ParkingDetailData(ParkingLot parkingLot, Double distance, Integer timeMoving, List<PriceTicketData> priceTicketDataList){
        this.id = parkingLot.getId();
        this.parkingLotName = parkingLot.getParkingLotName();
        this.street = parkingLot.getStreet();
        this.ward = parkingLot.getWard();
        this.district = parkingLot.getDistrict();
        this.city = parkingLot.getCity();
        this.lat = parkingLot.getLat();
        this.ing = parkingLot.getIng();
        this.status = parkingLot.getStatus();
        this.timeOpen = parkingLot.getTimeOpen();
        this.timeClose = parkingLot.getTimeClose();
        this.phoneNumber = parkingLot.getPhoneNumber();
        this.distance = distance;
        this.timeMoving = timeMoving;
        this.priceTicketList = priceTicketDataList;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<PriceTicketData> getPriceTicketList() {
        return priceTicketList;
    }

    public void setPriceTicketList(List<PriceTicketData> priceTicketList) {
        this.priceTicketList = priceTicketList;
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