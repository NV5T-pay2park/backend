package com.example.pay2parkbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "price_tickets")
public class PriceTicket {
    @EmbeddedId
    private PriceTicketId id;

    @MapsId("parkingLotId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "parking_lot_id", nullable = false)
    private ParkingLot parkingLot;

    @MapsId("vehicleTypeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_type_id", nullable = false)
    private VehicleType vehicleType;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "unit", nullable = false)
    private Long unit;

    public PriceTicketId getId() {
        return id;
    }

    public void setId(PriceTicketId id) {
        this.id = id;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getUnit() {
        return unit;
    }

    public void setUnit(Long unit) {
        this.unit = unit;
    }

}