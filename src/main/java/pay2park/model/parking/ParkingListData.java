package pay2park.model.parking;

import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.image.ImageResponse;

import java.util.List;

public class ParkingListData {

    private Integer id;
    private String parkingLotName;
    private String timeOpen;
    private String timeClose;
    private String street;
    private String ward;
    private String district;
    private String city;
    private Double lat;
    private Double lng;
    private Integer status;
    private String phoneNumber;
    private Double distance;
    private Integer timeMoving;
    private List<ImageResponse> images;


    public ParkingListData(ParkingLot parkingLot, Double distance, Integer timeMoving, List<ImageResponse> images){
        this.id = parkingLot.getId();
        this.parkingLotName = parkingLot.getParkingLotName();
        this.timeOpen = parkingLot.getTimeOpen();
        this.timeClose = parkingLot.getTimeClose();
        this.street = parkingLot.getStreet();
        this.ward = parkingLot.getWard();
        this.district = parkingLot.getDistrict();
        this.city = parkingLot.getCity();
        this.lat = parkingLot.getLat();
        this.lng = parkingLot.getLng();
        this.status = parkingLot.getStatus();
        this.phoneNumber = parkingLot.getPhoneNumber();
        this.distance = distance;
        this.timeMoving = timeMoving;
        this.images = images;
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

    public String getTimeOpen() {
        return timeOpen;
    }

    public void setTimeOpen(String timeOpen) {
        this.timeOpen = timeOpen;
    }

    public String getTimeClose() {
        return timeClose;
    }

    public void setTimeClose(String timeClose) {
        this.timeClose = timeClose;
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

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
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

    public List<ImageResponse> getImages() {
        return images;
    }

    public void setImages(List<ImageResponse> images) {
        this.images = images;
    }
}