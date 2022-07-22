package pay2park.model.entityFromDB;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import pay2park.model.parking.PriceTicketData;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@JsonInclude(JsonInclude.Include.ALWAYS)

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
    private Integer price;

    @Column(name = "unit", nullable = false)
    private Integer unit;

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

    public PriceTicketData toPriceTicketData(PriceTicket priceTicket){
        return new PriceTicketData(priceTicket.getId(), priceTicket.getVehicleType() ,priceTicket.getPrice(), priceTicket.getUnit());
    }
}