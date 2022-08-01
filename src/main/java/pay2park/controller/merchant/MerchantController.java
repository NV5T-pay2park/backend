package pay2park.controller.merchant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.service.merchant.MerchantService;

import java.io.IOException;

@RestController
@RequestMapping("/api/merchant/merchant/")
@CrossOrigin
public class MerchantController {
    @Autowired
    MerchantService merchantService;

    @GetMapping("/getByEmployeeId/{employeeId}")
    @ResponseBody
    public ResponseObject getByEmployeeId(@PathVariable Integer employeeId) throws IOException {
        Integer data = merchantService.getByEmployeeId(employeeId);
        return new ResponseObject(HttpStatus.OK, "successfully", data);
    }
}
