package pay2park.service.checkinout;

import org.springframework.stereotype.Service;
import pay2park.model.ResponseObject;
import pay2park.model.checkinout.CheckInData;
import pay2park.model.parking.VehicleData;

@Service
public interface CheckInService {
    ResponseObject checkIn(CheckInData checkInData);

    ResponseObject getInformationCheckInData(VehicleData informationCheckIn);
}
