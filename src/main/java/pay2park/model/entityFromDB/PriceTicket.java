package pay2park.model.entityFromDB;

import pay2park.model.merchant.PriceItem;

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


    @Column(name = "period_time", nullable = false, insertable=false, updatable=false)
    private Integer periodTime;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "unit", nullable = false)
    private Integer unit;

    public PriceTicket() {
    }

    public PriceTicket(PriceTicketId id, ParkingLot parkingLot, VehicleType vehicleType, Integer periodTime, Integer price, Integer unit) {
        this.id = id;
        this.parkingLot = parkingLot;
        this.vehicleType = vehicleType;
        this.periodTime = periodTime;
        this.price = price;
        this.unit = unit;
    }

    public PriceTicket(ParkingLot parkingLot, VehicleType vehicleType, PriceItem priceItem) {
        this.id = new PriceTicketId(parkingLot.getId(), vehicleType.getId(), priceItem.periodTime);
        this.parkingLot = parkingLot;
        this.vehicleType = vehicleType;
        this.periodTime = priceItem.periodTime;
        this.price = priceItem.price;
        this.unit = priceItem.unit;
    }

    public Integer getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(Integer periodTime) {
        this.periodTime = periodTime;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public PriceTicketId getId() {
        return id;
    }

    public void setId(PriceTicketId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PriceTicket{" +
                "id=" + id +
                ", parkingLot=" + parkingLot +
                ", vehicleType=" + vehicleType +
                ", periodTime=" + periodTime +
                ", price=" + price +
                ", unit=" + unit +
                '}';
    }
}