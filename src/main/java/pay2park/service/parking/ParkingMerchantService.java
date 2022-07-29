package pay2park.service.parking;

import pay2park.model.parking.ParkingMerchantListData;

import java.util.List;

public interface ParkingMerchantService {
    public List<ParkingMerchantListData> list(int merchantId);
    public boolean create(int merchantId);
}
