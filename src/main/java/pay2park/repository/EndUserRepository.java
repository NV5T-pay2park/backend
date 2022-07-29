package pay2park.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pay2park.model.entityFromDB.EndUser;

import java.util.List;

@Repository
public interface EndUserRepository extends JpaRepository<EndUser, Integer> {
    @Query(value = "SELECT user FROM EndUser user WHERE user.zalopayId = ?1")
    List<EndUser> getEndUserBaseOnZalopayID(String zalopayID);

}
