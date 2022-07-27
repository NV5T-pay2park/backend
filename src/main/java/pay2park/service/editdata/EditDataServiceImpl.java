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
import java.util.Optional;

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
    public String insertParkingLot(int id, String name, String street, String ward, String district, String city){ //String name, String street, String ward, String district, String city) {
        Optional<ParkingLot> parkingLot1 = parkingLotRepository.findById(id);
        ParkingLot parkingLot = parkingLot1.get();
        parkingLot.setParkingLotName(name);
        parkingLot.setStreet(street);
        parkingLot.setWard(ward);
        parkingLot.setDistrict(district);
        parkingLot.setCity(city);
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
