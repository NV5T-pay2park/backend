package pay2park.service.merchant;

import pay2park.model.merchant.ParkingLotCreateData;
import pay2park.model.merchant.ParkingLotGetData;
import pay2park.model.merchant.ParkingLotListData;
import pay2park.model.merchant.ParkingLotUpdateData;

import java.util.List;

public interface ParkingLotService {
    List<ParkingLotListData> list(Integer merchantId);
    boolean create(ParkingLotCreateData parkingLotCreateData);

    boolean delete(Integer parkingLotId);

    boolean update(ParkingLotUpdateData parkingLotUpdateData);

    ParkingLotGetData getParkingLot(Integer parkingLotId);
}
