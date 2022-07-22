package pay2parkbackend.model.parking;

import pay2parkbackend.model.entityFromDB.PriceTicketId;
import pay2parkbackend.model.entityFromDB.VehicleType;

import javax.persistence.Column;

public class PriceTicketData {
    private PriceTicketId id;

    private VehicleType vehicleType;

    private Integer price;


    private Integer unit;


    public PriceTicketData(PriceTicketId id, VehicleType vehicleType, Integer price, Integer unit) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.price = price;
        this.unit = unit;
    }

    public PriceTicketId getId() {
        return id;
    }

    public void setId(PriceTicketId id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }
}