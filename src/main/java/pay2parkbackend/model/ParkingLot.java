package com.example.pay2parkbackend.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.ALWAYS)
@Entity
@Table(name = "parking_lots")
public class ParkingLot {
    @Id
    @Column(name = "parking_lot_id", nullable = false)
    private Long id;

    @Column(name = "parking_lot_name", length = 50)
    private String parkingLotName;

    @Column(name = "number_slot", nullable = false)
    private Long numberSlot;

    @Column(name = "number_slot_remaining", nullable = false)
    private Long numberSlotRemaining;

    @Column(name = "address", nullable = false, length = 100)
    private String address;

    @Column(name = "status", nullable = false)
    private Long status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "merchant_id", nullable = false)
    private Merchant merchant;

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

    public Long getNumberSlot() {
        return numberSlot;
    }

    public void setNumberSlot(Long numberSlot) {
        this.numberSlot = numberSlot;
    }

    public Long getNumberSlotRemaining() {
        return numberSlotRemaining;
    }

    public void setNumberSlotRemaining(Long numberSlotRemaining) {
        this.numberSlotRemaining = numberSlotRemaining;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

}