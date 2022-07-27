package pay2park.controller.checkinout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.checkinout.CheckOutData;
import pay2park.model.checkinout.PreCheckOutData;
import pay2park.service.checkinout.CheckOutService;
import pay2park.service.ticket.TicketService;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CheckOutController {
    @Autowired
    CheckOutService checkOutService;

    @Autowired
    TicketService ticketService;

    @PostMapping("/preCheckOut")
    public ResponseEntity<ResponseObject> preCheckOut(@RequestBody PreCheckOutData preCheckOutData) throws IOException {
        ResponseObject responseObject = checkOutService.preCheckOut(preCheckOutData);
        return ResponseEntity.status(responseObject.getStatus()).body(responseObject);
    }


    @PostMapping("/checkOut")
    public ResponseEntity<ResponseObject> checkOut(@RequestBody CheckOutData checkOutData) throws IOException, InterruptedException {
        ResponseObject responseObject = checkOutService.checkOut(checkOutData);
        return ResponseEntity.status(responseObject.getStatus()).body(responseObject);
    }

}
