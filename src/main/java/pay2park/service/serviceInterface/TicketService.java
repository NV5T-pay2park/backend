package pay2park.service.serviceInterface;

import pay2park.model.entityResponse.ResponseObject;
import pay2park.model.entityRequest.TicketData;
import pay2park.model.entityResponse.ResponseTicketData;


public interface TicketService {
    ResponseTicketData createTicket(TicketData ticketData);
    ResponseObject getTicketByEndUserId(int endUserID);
}
