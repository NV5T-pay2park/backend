package pay2park.service.merchant;

import pay2park.model.merchant.*;

import java.util.List;

public interface ParkingLotService {
    List<ParkingLotListData> list(Integer merchantId);
    ParkingLotCreateResponseData create(ParkingLotCreateData parkingLotCreateData);

    boolean delete(Integer parkingLotId);

    boolean update(ParkingLotUpdateData parkingLotUpdateData);

    ParkingLotGetData getParkingLot(Integer parkingLotId);

    Integer getByEmployeeId(Integer employeeId);
}
