package pay2park.service.parking;

import pay2park.model.parking.ParkingMerchantCreateData;
import pay2park.model.parking.ParkingMerchantGetData;
import pay2park.model.parking.ParkingMerchantListData;
import pay2park.model.parking.ParkingMerchantUpdateData;

import java.util.List;

public interface ParkingMerchantService {
    List<ParkingMerchantListData> list(Integer merchantId);
    boolean create(ParkingMerchantCreateData parkingMerchantCreateData);

    boolean delete(Integer parkingLotId);

    boolean update(ParkingMerchantUpdateData parkingMerchantUpdateData);

    ParkingMerchantGetData getParkingLot(Integer parkingLotId);
}
