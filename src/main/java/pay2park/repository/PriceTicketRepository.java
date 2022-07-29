package pay2park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.PriceTicket;
import pay2park.model.entityFromDB.PriceTicketId;

import java.util.List;

@Repository
public interface PriceTicketRepository extends JpaRepository<PriceTicket, PriceTicketId> {
    @Query(value = "SELECT price_ticket FROM PriceTicket price_ticket WHERE price_ticket.parkingLot = ?1")
    List<PriceTicket> findByParkingLotId(ParkingLot parkingLotId);

    @Query(value = "SELECT price_ticket FROM PriceTicket price_ticket WHERE price_ticket.parkingLot = ?1 AND price_ticket.vehicleType = ?2")
    List<PriceTicket> getPriceTicketByParkingLotIdAndVehicleType(ParkingLot parkingLot, VehicleType vehicleType);

    @Query(value = "SELECT DISTINCT parkingLot FROM PriceTicket priceTicket WHERE priceTicket.vehicleType.id = :type")
    List<ParkingLot> filterWithAVehicleType(@Param("type") Integer vehicleType);

    @Query(value = "SELECT DISTINCT parking_lot_id FROM price_tickets WHERE vehicle_type_id = :type",nativeQuery = true)
    List<Integer> filterIdWithAVehicleType(@Param("type") Integer vehicleType);

}
