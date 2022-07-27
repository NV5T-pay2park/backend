package pay2park.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pay2park.model.entityFromDB.EndUser;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.Ticket;

import java.time.Instant;
import java.util.List;

@Repository
public interface TicketsRepository extends JpaRepository<Ticket, Long> {
    @Query(value = "SELECT ticket FROM Ticket ticket WHERE ticket.endUser = ?1")
    List<Ticket> getAllTicketByEndUserID(EndUser endUser);
    @Query(value = "SELECT ticket FROM Ticket ticket WHERE ticket.endUser = ?1 AND ticket.parkingLot = ?2 AND ticket.checkOutTime IS NULL")
    List<Ticket> getTicketByEndUserIDAndParkingLot(EndUser endUser, ParkingLot parkingLot);
}
