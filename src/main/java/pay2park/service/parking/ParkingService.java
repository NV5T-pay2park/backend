package pay2park.service.parking;

import org.springframework.web.bind.annotation.RequestParam;
import pay2park.model.parking.ParkingDetailData;
import pay2park.model.parking.ParkingListData;

import java.util.List;

public interface ParkingService {
    List<ParkingListData> getAllParking();
    List<ParkingListData> getParking(String coordinates,String stringSearch,String vehicleTypes);
    ParkingDetailData getParkingById(Integer parkingLotId, String coordinates);
}
