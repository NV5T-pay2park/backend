package pay2park.controller.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.entityFromDB.VehicleType;
import pay2park.service.merchant.VehicleTypeService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/merchant/vehicleType/")
@CrossOrigin
public class VehicleTypeController {

    @Autowired
    VehicleTypeService vehicleTypeService;

    @GetMapping("/list")
    @ResponseBody
    public ResponseObject list() throws IOException {
        List<VehicleType> data = vehicleTypeService.list();
        return new ResponseObject(HttpStatus.OK, "successfully", data);
    }
}
