package com.example.pay2parkbackend.repositories;

import com.example.pay2parkbackend.model.EndUser;
import com.example.pay2parkbackend.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketsRepository extends JpaRepository<Ticket, Long> {
    @Query(value = "SELECT ticket FROM Ticket ticket WHERE ticket.endUser = ?1")
    List<Ticket> getAllTicketByEndUserID(Optional<EndUser> endUserID);
}
