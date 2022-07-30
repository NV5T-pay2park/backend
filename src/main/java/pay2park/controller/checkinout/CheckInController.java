package pay2park.controller.checkinout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.checkinout.CheckInData;
import pay2park.model.checkinout.CheckInInformation;
import pay2park.service.checkinout.CheckInService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CheckInController {
    @Autowired
    CheckInService checkInService;

    @PostMapping("/checkIn")
    public ResponseEntity<ResponseObject> checkIn(@RequestBody CheckInData checkInData) {
        ResponseObject responseObject = checkInService.checkIn(checkInData);
        return ResponseEntity.status(responseObject.getStatus()).body(responseObject);
    }

    @PostMapping("/sendInformationCheckIn")
    public ResponseEntity<ResponseObject> getInformationCheckInData(
            @RequestBody CheckInInformation informationCheckIn) {
        ResponseObject responseObject = checkInService.getInformationCheckInData(informationCheckIn.getCheckInData(), informationCheckIn.getVehicleData());
        return ResponseEntity.status(responseObject.getStatus()).body(responseObject);
    }
}
