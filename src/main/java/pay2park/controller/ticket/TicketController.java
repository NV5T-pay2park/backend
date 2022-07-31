package pay2park.controller.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.ticket.ResponseTicketData;
import pay2park.repository.VehicleTypeRepository;
import pay2park.service.ticket.TicketService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @GetMapping("/getTicketByEndUserId")
    public ResponseEntity<ResponseObject> getTicketByEndUserId(@RequestParam(value = "endUserID") int endUserID) {
        ResponseObject responseObject = ticketService.getTicketByEndUserId(endUserID);
        return ResponseEntity.status(responseObject.getStatus()).body(responseObject);
    }
    @GetMapping("/getTicketById")
    public ResponseObject getTicketById(@RequestParam(value = "ticketId") long ticketId) {
        ResponseTicketData data = ticketService.getTicketById(ticketId);
        return
                new ResponseObject(HttpStatus.OK, "get ticket by id successfully ", data);
    }
}
