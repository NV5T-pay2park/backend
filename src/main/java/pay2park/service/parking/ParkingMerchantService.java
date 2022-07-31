package pay2park.service.parking;

import pay2park.model.parking.ParkingMerchantListData;

import java.util.List;

public interface ParkingMerchantService {
    List<ParkingMerchantListData> list(int merchantId);
    boolean create(int merchantId);
}
