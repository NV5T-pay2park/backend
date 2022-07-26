package pay2park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pay2park.model.entityFromDB.ParkingLotImage;

@Repository
public interface ParkingLotImageRepository extends JpaRepository<ParkingLotImage, String> {

}
