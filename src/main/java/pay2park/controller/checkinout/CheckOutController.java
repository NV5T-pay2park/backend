package pay2park.controller.checkinout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pay2park.model.ResponseObject;
import pay2park.model.checkinout.CheckInData;
import pay2park.model.checkinout.CheckOutData;
import pay2park.service.checkinout.CheckInService;
import pay2park.service.checkinout.CheckOutService;
import pay2park.service.ticket.TicketService;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class CheckOutController {
    @Autowired
    CheckOutService checkOutService;
    @PostMapping("/checkOut")
    public ResponseEntity<ResponseObject> checkIn(@RequestBody CheckOutData checkOutData) throws IOException {
        ResponseObject responseObject = checkOutService.checkOut(checkOutData);
        return ResponseEntity.status(responseObject.getStatus()).body(responseObject);
    }
}
