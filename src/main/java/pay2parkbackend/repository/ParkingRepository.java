package pay2parkbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pay2parkbackend.model.entityFromDB.ParkingLot;

@Repository
public interface ParkingRepository extends JpaRepository<ParkingLot, Long> {

//    @Query(value = "SELECT all FROM ParkingLot")
//    List<ParkingLot> getAllParking();

}
