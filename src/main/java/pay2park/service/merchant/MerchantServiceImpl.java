package pay2park.service.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pay2park.model.entityFromDB.MerchantEmployee;
import pay2park.repository.MerchantEmployeeRepository;
import pay2park.repository.MerchantRepository;

import java.util.Optional;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    MerchantEmployeeRepository merchantEmployeeRepository;

    @Override
    public Integer getByEmployeeId(Integer employeeId) {
        Optional<MerchantEmployee> merchantEmployeeOptional = merchantEmployeeRepository.findById(employeeId);
        if (!merchantEmployeeOptional.isPresent()) {
            System.out.println("Not found paking lot!!!");
            return null;
        }

        MerchantEmployee merchantEmployee = merchantEmployeeOptional.get();

        return merchantEmployee.getParkingLot().getMerchant().getId();
    }
}
