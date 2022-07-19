package pay2park.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import pay2park.model.EndUser;

public interface EndUserRepository extends JpaRepository<EndUser, Long> {
}
