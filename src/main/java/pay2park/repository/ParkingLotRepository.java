package pay2park.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pay2park.model.entityFromDB.ParkingLot;

import java.util.List;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Integer> {
    @Query(value = "SELECT parkingLot FROM ParkingLot parkingLot WHERE parkingLot.parkingLotName = ?1")
    List<ParkingLot> findSearch(String stringSearch);
}