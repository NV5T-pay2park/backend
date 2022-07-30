package pay2park.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pay2park.model.entityFromDB.MerchantEmployee;

import java.util.List;

@Repository
public interface MerchantEmployeeRepository extends JpaRepository<MerchantEmployee, Integer> {
    @Query(value = "SELECT employee FROM MerchantEmployee employee WHERE employee.phone = ?1 AND employee.password = ?2")
    List<MerchantEmployee> getMerchantEmployeeByPhoneAndPassword(String employeePhone, String employeePhonePassword);

    @Query(value = "SELECT employee.password FROM MerchantEmployee employee WHERE employee.phone = ?1")
    List<String> password(String employeePhone);
}
