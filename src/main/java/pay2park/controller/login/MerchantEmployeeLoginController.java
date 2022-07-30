package pay2park.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pay2park.model.ResponseObject;
import pay2park.model.login.MerchantEmployeeRequestLoginData;
import pay2park.service.login.MerchantEmployeeLoginService;

@RestController
@CrossOrigin
public class MerchantEmployeeLoginController {
    @Autowired
    MerchantEmployeeLoginService loginService;

    @PostMapping("api/loginmerchant")
    public ResponseEntity<ResponseObject> catchNewLoginMerchant(
            @RequestParam(value = "phone", defaultValue = "") String phone,
            @RequestParam(value = "password", defaultValue = "") String password) {
        ResponseObject res = loginService.login(new MerchantEmployeeRequestLoginData(phone, password));
        return ResponseEntity.status(res.getStatus()).body(res);
    }
}
