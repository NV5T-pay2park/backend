package pay2park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pay2park.model.entityFromDB.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}



