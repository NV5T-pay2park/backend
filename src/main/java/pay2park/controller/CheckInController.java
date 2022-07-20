package pay2park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.MethodInvocationRecorder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.service.CheckInService;
import pay2park.service.TicketService;

import java.util.Map;

@RestController
@RequestMapping("/api/")
public class CheckInController {
    @Autowired
    CheckInService checkInService;
    @Autowired
    TicketService ticketService;
    @PostMapping("checkIn")
    public ResponseEntity<ResponseObject> checkIn(@RequestBody Map<String, Object> checkInData) {
        var responseData = checkInService.checkIn(checkInData);
        return responseData.size() > 0 ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("OK", "OK", responseData)) :
                ResponseEntity.status(HttpStatus.FOUND).body(
                        new ResponseObject("FOUND", "FOUND", responseData));
    }
    @PostMapping("sendInformationCheckIn")
    public void getInformationCheckIn(@RequestBody Map<String, Object> informationCheckIn) {

    }
    @PostMapping("testCc")
    public ResponseEntity<ResponseObject> testCc(@RequestBody Map<String, Object> data) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK", "OK", checkInService.testCc(data)));
    }
}
