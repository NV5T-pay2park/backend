package pay2park.controller.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.parking.parkingMerchantCreate.ParkingMerchantCreateData;
import pay2park.model.parking.ParkingMerchantListData;
import pay2park.service.parking.ParkingMerchantService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/parkingMerchant/")
@CrossOrigin
public class ParkingMerchantController {

    @Autowired
    ParkingMerchantService parkingMerchantService;



    @GetMapping("/{merchantId}/list")
    @ResponseBody
    public ResponseObject list(@PathVariable int merchantId) throws IOException {

        List<ParkingMerchantListData> data = parkingMerchantService.list(merchantId);
        return new ResponseObject(HttpStatus.OK, "successfully", data);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseObject create(@RequestBody ParkingMerchantCreateData parkingMerchantCreateData) throws IOException {

        boolean data = parkingMerchantService.create(parkingMerchantCreateData);
        return new ResponseObject(HttpStatus.OK, "successfully", data);
    }

}
