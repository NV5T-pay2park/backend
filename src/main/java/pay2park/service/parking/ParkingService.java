package pay2park.service.parking;

import pay2park.model.parking.ParkingDetailData;
import pay2park.model.parking.ParkingListData;

import java.util.List;

public interface ParkingService {
    List<ParkingListData> getAllParking();

    ParkingDetailData getParkingById(Long parkingLotId);
}
