package pay2park.model.merchant;

import java.util.List;

public class PriceWithVehicle {
    public Integer vehicleTypeId;
    public List<PriceItem> prices;

    public PriceWithVehicle(Integer vehicleTypeId, List<PriceItem> prices) {
        this.vehicleTypeId = vehicleTypeId;
        this.prices = prices;
    }
    public PriceWithVehicle(){}
}
