package pay2park.controller.editdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.entityFromDB.Merchant;
import pay2park.model.entityFromDB.ParkingLot;
import pay2park.model.entityFromDB.VehicleType;
import pay2park.service.editdata.EditDataService;

@RestController
@RequestMapping("/api/")
public class EditDataController {
    @Autowired
    EditDataService testService;
    @PostMapping("insertVehicle")
    public ResponseEntity<ResponseObject> insertVehicle(@RequestBody VehicleType vehicleType) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(HttpStatus.OK, "", testService.insertVehicle(vehicleType, vehicleType.getVehicleTypeName())));
    }
    @PostMapping("insertParkingLot")
    public ResponseEntity<ResponseObject> insertParkingLot(@RequestBody ParkingLot parkingLot) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(HttpStatus.OK, "",
                        testService.insertParkingLot(parkingLot, parkingLot.getParkingLotName(), parkingLot.getAddress())));
    }
    @PostMapping("insertMerchant")
    public ResponseEntity<ResponseObject> insertMerchant(@RequestBody Merchant merchant) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(HttpStatus.OK, "", testService.insertMerchant(merchant, merchant.getName())));
    }
    @GetMapping("getAllParkingLot")
    public ResponseEntity<ResponseObject> getAllParkingLot() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(HttpStatus.OK, "", testService.getAllParkingLot()));
    }
    @GetMapping("getAllMerchant")
    public ResponseEntity<ResponseObject> getAllMerchant() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(HttpStatus.OK, "", testService.getAllMerchant()));
    }
    @GetMapping("getAllVehicleType")
    public ResponseEntity<ResponseObject> getAllVehicleType() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(HttpStatus.OK, "", testService.getAllVehicleType()));
    }
    @PostMapping("delete")
    public ResponseEntity<ResponseObject> delete(@RequestBody VehicleType vehicleType) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(HttpStatus.OK, "", testService.delete(vehicleType)));
    }
}
