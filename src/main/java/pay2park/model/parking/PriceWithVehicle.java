package pay2park.model.parking;

import java.util.List;

public class PriceWithVehicle {
    public Integer vehicleTypeId;
    public List<PriceItem> prices;

    public PriceWithVehicle(Integer vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }
}
