package pay2park.service.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pay2park.model.entityFromDB.VehicleType;
import pay2park.repository.VehicleTypeRepository;

import java.util.List;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {
    @Autowired
    VehicleTypeRepository vehicleTypeRepository;

    @Override
    public List<VehicleType> list(){
        return vehicleTypeRepository.findAll();
    }
}
