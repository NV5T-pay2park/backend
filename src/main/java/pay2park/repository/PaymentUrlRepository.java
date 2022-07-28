package pay2park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pay2park.model.entityFromDB.PaymentUrl;

public interface PaymentUrlRepository extends JpaRepository<PaymentUrl, String> {
}
