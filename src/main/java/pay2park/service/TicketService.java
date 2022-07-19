package pay2park.service;

import pay2park.model.Ticket;
import pay2park.model.TicketData;

import java.util.List;
import java.util.Map;

public interface TicketService {
    Map<String, Object> createTicket(TicketData ticketData);
    List<Ticket> getTicketByEndUserId(Long endUserID);
    List<Ticket> test();
}
