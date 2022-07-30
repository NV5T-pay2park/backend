package pay2park.model.parking.parkingMerchantCreate;

import java.util.List;

public class ParkingMerchantCreateData {

    public Integer merchantId;
    public String parkingLotName;
    public Integer numberSlot;
    public String street;
    public String ward;
    public String district;
    public String city;
    public Double lat;
    public Double lng;
    public String timeOpen;
    public String timeClose;
    public String phoneNumber;
    public List<PriceWithVehicle> priceTable;

}
