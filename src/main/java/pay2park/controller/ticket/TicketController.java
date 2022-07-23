package pay2park.controller.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.repository.VehicleTypeRepository;
import pay2park.service.ticket.TicketService;

@RestController
@RequestMapping("/api")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    @GetMapping("/getTicketByEndUserId")
    public ResponseEntity<ResponseObject> getTicketByEndUserId(@RequestParam(value = "endUserID") int endUserID) {
        ResponseObject responseObject = ticketService.getTicketByEndUserId(endUserID);
        return ResponseEntity.status(responseObject.getStatus()).body(responseObject);
    }
}