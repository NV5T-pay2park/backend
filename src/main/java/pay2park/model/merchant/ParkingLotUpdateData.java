package pay2park.model.merchant;

import java.util.List;

public class ParkingLotUpdateData {

    public Integer parkingLotId;
    public String parkingLotName;
    public Integer numberSlot;
    public String street;
    public String ward;
    public String district;
    public String city;
    public Integer status;
    public Double lat;
    public Double lng;
    public String timeOpen;
    public String timeClose;
    public String phoneNumber;
    public List<PriceWithVehicle> priceTable;

}
