package pay2park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.ParkingLotImage;

import java.util.List;

@Repository
public interface ParkingLotImageRepository extends JpaRepository<ParkingLotImage, String> {
    @Query(value = "SELECT parkingLotImage FROM ParkingLotImage parkingLotImage WHERE parkingLotImage.parkingLot = ?1")
    List<ParkingLotImage> getAllImageByParkingLot(ParkingLot parkingLot);
}
