package pay2park.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.login.MerchantEmployeeRequestLoginData;
import pay2park.service.login.MerchantEmployeeLoginService;

@RestController
@CrossOrigin
public class MerchantEmployeeLoginController {
    @Autowired
    MerchantEmployeeLoginService loginService;

    @PostMapping("api/loginmerchant")
    public ResponseEntity<ResponseObject> catchNewLoginMerchant(@RequestBody MerchantEmployeeRequestLoginData req) {
        ResponseObject res = loginService.login(req);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
}
