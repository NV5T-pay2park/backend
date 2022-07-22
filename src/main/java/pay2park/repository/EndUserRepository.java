package pay2park.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pay2park.model.entityFromDB.EndUser;

@Repository
public interface EndUserRepository extends JpaRepository<EndUser, Integer> {
}
