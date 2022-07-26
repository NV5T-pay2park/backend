package pay2park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pay2park.model.entityFromDB.Merchant;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
}
