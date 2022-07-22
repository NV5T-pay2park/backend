package pay2park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pay2park.model.entityFromDB.VehicleType;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {

}
