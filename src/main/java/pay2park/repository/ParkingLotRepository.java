package pay2park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pay2park.model.entityFromDB.ParkingLot;

import java.util.List;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {

    @Query(value = "select distinct parkingLot from PriceTicket priceTicket where priceTicket.vehicleType.id in (:types)")
    List<ParkingLot> filterWithVehicleType(@Param("types") List<Integer> vehicleType);

    @Query(value = "select distinct parking_lot_id from price_tickets where vehicle_type_id in (:types)",nativeQuery = true)
    List<Integer> filterIdWithVehicleType(@Param("types") List<Integer> vehicleType);

    @Query(value = "select * from parking_lots where match(parking_lot_name, address) AGAINST (:string)", nativeQuery = true)
    List<ParkingLot> searchWithStringSearch(@Param("string") String stringSearch);

    @Query(value = "select * from parking_lots where match(parking_lot_name, address) AGAINST (:string) AND parking_lot_id IN (:parkingLotIdList)", nativeQuery = true)
    List<ParkingLot> searchWithStringSearchAndIdList(@Param("string") String stringSearch, @Param("parkingLotIdList") List<Integer> parkingLotIdList);

    @Query(value = "select parkingLot from ParkingLot parkingLot where parkingLot.parkingLotName like %:string%")
    List<ParkingLot> searchWithLikeStringSearch(@Param("string") String stringSearch);

    @Query(value = "select * from parking_lots where (parking_lot_name like %:string% or address like %:string%) AND parking_lot_id IN (:parkingLotIdList)", nativeQuery = true )
    List<ParkingLot> searchWithLikeStringSearchAndIdList(@Param("string") String stringSearch, @Param("parkingLotIdList") List<Integer> parkingLotIdList);

}


