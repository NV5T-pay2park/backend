package pay2park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pay2park.model.entityRequest.CheckInData;
import pay2park.model.entityRequest.VehicleData;
import pay2park.model.entityResponse.ResponseObject;
import pay2park.service.serviceInterface.CheckInService;
import pay2park.service.serviceInterface.TicketService;

@RestController
@RequestMapping("/api")
public class CheckInController {
    @Autowired
    CheckInService checkInService;
    @Autowired
    TicketService ticketService;
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
