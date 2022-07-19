package com.example.pay2parkbackend.service;

import com.example.pay2parkbackend.model.*;

import java.util.List;
import java.util.Map;

public interface TicketService {
    Map<String, Object> createTicket(TicketData ticketData);
    List<Ticket> getTicketByEndUserId(Long endUserID);
    List<Ticket> test();
}
