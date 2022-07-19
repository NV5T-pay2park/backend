package pay2park.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pay2park.model.EndUser;
import pay2park.model.Ticket;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketsRepository extends JpaRepository<Ticket, Long> {
    @Query(value = "SELECT ticket FROM Ticket ticket WHERE ticket.endUser = ?1")
    List<Ticket> getAllTicketByEndUserID(Optional<EndUser> endUserID);
}
