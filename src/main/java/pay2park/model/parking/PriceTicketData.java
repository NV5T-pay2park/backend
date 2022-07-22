package pay2park.model.parking;

import pay2park.model.entityFromDB.PriceTicket;
import pay2park.model.entityFromDB.PriceTicketId;
import pay2park.model.entityFromDB.VehicleType;

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

    public PriceTicketData(PriceTicket priceTicket){
        this.id = priceTicket.getId();
        this.vehicleType = priceTicket.getVehicleType();
        this.price = priceTicket.getPrice();
        this.unit = priceTicket.getUnit();
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