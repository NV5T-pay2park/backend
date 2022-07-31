package pay2park.controller.parking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.merchant.ParkingLotListData;
import pay2park.service.merchant.ParkingLotService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/parkingMerchant/")
@CrossOrigin
public class ParkingMerchantController {
    @Autowired
    ParkingLotService parkingLotService;
    @GetMapping("/{merchantId}/list")
    @ResponseBody
    public ResponseObject list(@PathVariable int merchantId) throws IOException {

//        List<ParkingMerchantListData> data = parkingMerchantService.list(merchantId);
        ParkingLotListData data = parkingLotService.list(merchantId).get(0);
        return new ResponseObject(HttpStatus.OK, "successfully", data);
    }
}
