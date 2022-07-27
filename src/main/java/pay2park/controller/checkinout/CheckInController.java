package pay2park.controller.checkinout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.checkinout.CheckInData;
import pay2park.model.parking.VehicleData;
import pay2park.service.checkinout.CheckInService;
import pay2park.service.ticket.TicketService;

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
            @RequestBody VehicleData informationCheckIn) {
        ResponseObject responseObject = checkInService.getInformationCheckInData(informationCheckIn);
        return ResponseEntity.status(responseObject.getStatus()).body(responseObject);
    }
}
