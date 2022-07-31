package pay2park.service.ticket;

import pay2park.model.ResponseObject;
import pay2park.model.ticket.TicketData;
import pay2park.model.ticket.ResponseTicketData;


public interface TicketService {
    ResponseTicketData createTicket(TicketData ticketData);
    ResponseTicketData getTicketById(Long id);
    ResponseObject getTicketByEndUserId(int endUserID);

    ResponseObject getTicketByParkingLotId(int parkingLotId);
}
