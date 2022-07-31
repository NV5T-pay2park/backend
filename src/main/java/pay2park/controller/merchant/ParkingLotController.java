package pay2park.controller.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.merchant.ParkingLotCreateData;
import pay2park.model.merchant.ParkingLotGetData;
import pay2park.model.merchant.ParkingLotListData;
import pay2park.model.merchant.ParkingLotUpdateData;
import pay2park.service.merchant.ParkingLotService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/merchant/parkingLot")
@CrossOrigin
public class ParkingLotController {

    @Autowired
    ParkingLotService parkingLotService;

    @GetMapping("/{merchantId}/list")
    @ResponseBody
    public ResponseObject list(@PathVariable Integer merchantId) throws IOException {

        List<ParkingLotListData> data = parkingLotService.list(merchantId);
        return new ResponseObject(HttpStatus.OK, "successfully", data);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseObject create(@RequestBody ParkingLotCreateData parkingLotCreateData) throws IOException {
        boolean data = parkingLotService.create(parkingLotCreateData);
        return new ResponseObject(HttpStatus.OK, "successfully", data);
    }

    @GetMapping("/delete/{parkingLotId}")
    @ResponseBody
    public ResponseObject delete(@PathVariable Integer parkingLotId) throws IOException {

        boolean data = parkingLotService.delete(parkingLotId);
        return new ResponseObject(HttpStatus.OK, "successfully", data);
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseObject update(@RequestBody ParkingLotUpdateData parkingLotUpdateData) throws IOException {

        boolean data = parkingLotService.update(parkingLotUpdateData);
        return new ResponseObject(HttpStatus.OK, "successfully", data);
    }

    @GetMapping("/get/{parkingLotId}")
    @ResponseBody
    public ResponseObject getParkingLot(@PathVariable Integer parkingLotId) throws IOException {
        ParkingLotGetData data = parkingLotService.getParkingLot(parkingLotId);
        return new ResponseObject(HttpStatus.OK, "successfully", data);
    }
}
