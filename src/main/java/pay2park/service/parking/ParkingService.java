package pay2park.service.parking;

import org.springframework.web.bind.annotation.RequestParam;
import pay2park.model.parking.ParkingDetailData;
import pay2park.model.parking.ParkingListData;

import java.io.IOException;
import java.util.List;

public interface ParkingService {
    List<ParkingListData> getAllParking();
    List<ParkingListData> searchAndFilterParking(String stringSearch, String vehicleTypes, String district, String coordinates);
    ParkingDetailData getParkingById(Integer parkingLotId, String coordinates) throws IOException;
}
