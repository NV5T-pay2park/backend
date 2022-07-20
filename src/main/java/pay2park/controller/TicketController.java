package pay2park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.Ticket;
import pay2park.model.TicketData;
import pay2park.repositories.VehicleTypeRepository;
import pay2park.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;
    @GetMapping("getTicketByEndUserId")
    public ResponseEntity<ResponseObject> getTicketByEndUserId(@RequestParam(value = "endUserID") Long endUserID) {
        var data = ticketService.getTicketByEndUserId(endUserID);
        return data.size() > 0 ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "OK", data)) :
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("FOUND", "FOUND", data));
    }
    @PostMapping("createTicket")
    public ResponseEntity<ResponseObject> createTicket(@RequestBody TicketData ticketData) {
//        return ResponseEntity.status(HttpStatus.OK).body(
//                new ResponseObject("OK", "OK", ticketService.createTicket(ticketData))
//        );
        var responseData = ticketService.createTicket(ticketData);
        return responseData.size() > 0 ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("OK", "OK", responseData)) :
                ResponseEntity.status(HttpStatus.FOUND).body(
                        new ResponseObject("FOUND", "Data is not valid", responseData));
    }
    @GetMapping("test")
    public ResponseEntity<ResponseObject> test() {
        List<Ticket> data = ticketService.test();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK", "OK", data));
    }
}
