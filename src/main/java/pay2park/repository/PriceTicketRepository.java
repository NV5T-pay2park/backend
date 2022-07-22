package pay2park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.PriceTicket;
import pay2park.model.entityFromDB.PriceTicketId;

import java.util.List;

@Repository
public interface PriceTicketRepository extends JpaRepository<PriceTicket, PriceTicketId> {
    @Query(value = "SELECT price_ticket FROM PriceTicket price_ticket WHERE price_ticket.parkingLot = ?1")
    List<PriceTicket> findByParkingLotId(ParkingLot parkingLotId);
}
