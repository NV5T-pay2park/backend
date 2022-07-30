package pay2park.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pay2park.model.entityFromDB.Permission;

import java.util.List;


@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    @Query(value = "SELECT permission FROM Permission permission WHERE permission.id = ?1")
    List<Permission> getPermissionById(int id);
}
