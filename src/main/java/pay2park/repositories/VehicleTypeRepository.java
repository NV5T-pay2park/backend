package pay2park.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pay2park.model.VehicleType;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
}
