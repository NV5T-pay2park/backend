package pay2park.model.entityFromDB;

import javax.persistence.*;

@Entity
@Table(name = "parking_lots")
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_lot_id", nullable = false)
    private Integer id;

    @Column(name = "parking_lot_name", length = 50)
    private String parkingLotName;

    @Column(name = "number_slot", nullable = false)
    private Integer numberSlot;

    @Column(name = "number_slot_remaining", nullable = false)
    private Integer numberSlotRemaining;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Column(name = "status", nullable = false)
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

    @Column(name = "lat", nullable = false)
    private Double lat;

    @Column(name = "ing", nullable = false)
    private Double ing;

    @Column(name = "time_open", nullable = false)
    private Integer timeOpen;

    @Column(name = "time_close", nullable = false)
    private Integer timeClose;

    @Column(name = "phone_number", length = 10)
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getTimeClose() {
        return timeClose;
    }

    public void setTimeClose(Integer timeClose) {
        this.timeClose = timeClose;
    }

    public Integer getTimeOpen() {
        return timeOpen;
    }

    public void setTimeOpen(Integer timeOpen) {
        this.timeOpen = timeOpen;
    }

    public Double getIng() {
        return ing;
    }

    public void setIng(Double ing) {
        this.ing = ing;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumberSlotRemaining() {
        return numberSlotRemaining;
    }

    public void setNumberSlotRemaining(Integer numberSlotRemaining) {
        this.numberSlotRemaining = numberSlotRemaining;
    }

    public Integer getNumberSlot() {
        return numberSlot;
    }

    public void setNumberSlot(Integer numberSlot) {
        this.numberSlot = numberSlot;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}