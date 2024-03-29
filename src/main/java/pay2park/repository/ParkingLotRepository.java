package pay2park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pay2park.model.entityFromDB.ParkingLot;

import java.util.List;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {

    @Query(value = "SELECT * FROM parking_lots WHERE MATCH(parking_lot_name) AGAINST (:string)", nativeQuery = true)
    List<ParkingLot> searchWithStringSearch(@Param("string") String stringSearch);

    @Query(value = "SELECT * FROM parking_lots WHERE MATCH(parking_lot_name) AGAINST (:string) AND parking_lot_id IN (:parkingLotIdList)", nativeQuery = true)
    List<ParkingLot> searchWithStringSearchAndIdList(@Param("string") String stringSearch, @Param("parkingLotIdList") List<Integer> parkingLotIdList);

    @Query(value = "SELECT parkingLot FROM ParkingLot parkingLot WHERE parkingLot.parkingLotName LIKE %:string%")
    List<ParkingLot> searchWithLikeStringSearch(@Param("string") String stringSearch);

    @Query(value = "SELECT * FROM parking_lots WHERE parking_lot_name LIKE %:string% AND parking_lot_id IN (:parkingLotIdList)", nativeQuery = true)
    List<ParkingLot> searchWithLikeStringSearchAndIdList(@Param("string") String stringSearch, @Param("parkingLotIdList") List<Integer> parkingLotIdList);


    @Query(value = "select * from parking_lots where merchant_id = ?1", nativeQuery = true)
    List<ParkingLot> findByMerchantId(int merchant_id);

}


