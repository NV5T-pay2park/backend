package pay2parkbackend.model.entityFromDB;

import pay2parkbackend.model.parking.ParkingDetailData;
import pay2parkbackend.model.parking.ParkingListData;
import pay2parkbackend.model.parking.PriceTicketData;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parking_lots")
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parking_lot_id", nullable = false)
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // map data
    public ParkingListData toParkingListData(ParkingLot parkingLot){
        return new ParkingListData(parkingLot.getId(), parkingLot.getParkingLotName(),parkingLot.getLat(), parkingLot.getIng(), parkingLot.getTimeOpen(), parkingLot.getTimeClose(), parkingLot.getStatus());
    }

    public ParkingDetailData toParkingDetailData(ParkingLot parkingLot, List<PriceTicketData> priceTicketDataList){
        return new ParkingDetailData(parkingLot.getId(), parkingLot.getParkingLotName(),parkingLot.getAddress(), parkingLot.getStatus(), parkingLot.getLat(), parkingLot.getIng(), parkingLot.getTimeOpen(), parkingLot.getTimeClose(),priceTicketDataList);
    }
}

