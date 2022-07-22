package pay2parkbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pay2parkbackend.model.entityFromDB.ParkingLot;
import pay2parkbackend.model.entityFromDB.PriceTicket;
import pay2parkbackend.model.entityFromDB.PriceTicketId;
import pay2parkbackend.model.parking.PriceTicketData;

import java.util.List;

public interface PriceTicketRepository extends JpaRepository<PriceTicket, PriceTicketId> {
    @Query(value = "SELECT price_ticket FROM PriceTicket price_ticket WHERE price_ticket.parkingLot = ?1")
    List<PriceTicket> findByParkingLotId(ParkingLot parkingLotId);
}
