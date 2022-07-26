package pay2park.service.editdata;

import pay2park.model.entityFromDB.Merchant;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.VehicleType;

import java.util.List;

public interface EditDataService {
    String insertMerchant(Merchant merchant, String name);
    String insertParkingLot(ParkingLot parkingLot, String name, String address);
    String insertVehicle(VehicleType vehicleType, String name);
    List<VehicleType> getAllVehicleType();
    List<ParkingLot> getAllParkingLot();
    List<Merchant> getAllMerchant();
    String delete(VehicleType vehicleType);
}
