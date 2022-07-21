package pay2parkbackend.service.parking;

import pay2parkbackend.model.entityFromDB.ParkingLot;
import pay2parkbackend.model.parking.ParkingDetailData;
import pay2parkbackend.model.parking.ParkingListData;

import java.util.List;

public interface ParkingService {
    List<ParkingListData> getAllParking();

    ParkingDetailData getParkingById(Long parkingLotId);
}
