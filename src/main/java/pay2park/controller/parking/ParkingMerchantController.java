package pay2park.controller.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
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
<<<<<<< HEAD

=======
>>>>>>> 73b6d4dbaa5799a4b5b692b376cc9413c3dd9916
    @GetMapping("/{merchantId}/list")
    @ResponseBody
    public ResponseObject list(@PathVariable int merchantId) throws IOException {

//        List<ParkingMerchantListData> data = parkingMerchantService.list(merchantId);
        ParkingMerchantListData data = parkingMerchantService.list(merchantId).get(0);
        return new ResponseObject(HttpStatus.OK, "successfully", data);
    }
}
