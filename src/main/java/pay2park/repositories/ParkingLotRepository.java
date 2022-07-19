package pay2park.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pay2park.model.ParkingLot;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
}