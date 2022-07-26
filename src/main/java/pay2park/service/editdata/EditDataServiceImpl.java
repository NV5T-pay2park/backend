package pay2park.service.editdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pay2park.model.entityFromDB.Merchant;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.VehicleType;
import pay2park.repository.MerchantRepository;
import pay2park.repository.ParkingLotRepository;
import pay2park.repository.VehicleTypeRepository;

import java.util.List;

@Service
public class EditDataServiceImpl implements EditDataService {
    @Autowired
    VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    MerchantRepository merchantRepository;
    @Autowired
    ParkingLotRepository parkingLotRepository;
    @Override
    public String insertMerchant(Merchant merchant, String name) {
        merchant.setName(name);
        merchantRepository.save(merchant);
        return "YES";
    }
    @Override
    public String insertParkingLot(ParkingLot parkingLot, String name, String address) {
        parkingLot.setParkingLotName(name);
        parkingLot.setAddress(address);
        parkingLotRepository.save(parkingLot);
        return "YES";
    }
    @Override
    public String insertVehicle(VehicleType vehicleType, String name) {
        vehicleType.setVehicleTypeName(name);
        vehicleTypeRepository.save(vehicleType);
        return "YES";
    }
    @Override
    public List<VehicleType> getAllVehicleType() {
        return vehicleTypeRepository.findAll();
    }

    @Override
    public List<ParkingLot> getAllParkingLot() {
        return parkingLotRepository.findAll();
    }

    @Override
    public List<Merchant> getAllMerchant() {
        return merchantRepository.findAll();
    }

    @Override
    public String delete(VehicleType vehicleType) {
        vehicleTypeRepository.delete(vehicleType);
        return "YES";
    }
}
