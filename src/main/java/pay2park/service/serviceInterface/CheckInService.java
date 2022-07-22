package pay2park.service.serviceInterface;

import org.springframework.stereotype.Service;
import pay2park.model.entityRequest.CheckInData;
import pay2park.model.entityRequest.VehicleData;
import pay2park.model.entityResponse.ResponseObject;

import java.util.Map;

@Service
public interface CheckInService {
    ResponseObject checkIn(CheckInData checkInData);
    ResponseObject getInformationCheckInData(VehicleData informationCheckIn);
}
