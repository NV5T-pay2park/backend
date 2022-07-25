package pay2park.service.parking;

import org.springframework.web.bind.annotation.RequestParam;
import pay2park.model.parking.ParkingDetailData;
import pay2park.model.parking.ParkingListData;

import java.io.IOException;
import java.util.List;

public interface ParkingService {
    List<ParkingListData> getAllParking();
    List<ParkingListData> filterParking(String coordinates,String vehicleTypes);
    List<ParkingListData> searchParking(String stringSearch);
    ParkingDetailData getParkingById(Integer parkingLotId, String coordinates) throws IOException;
}
