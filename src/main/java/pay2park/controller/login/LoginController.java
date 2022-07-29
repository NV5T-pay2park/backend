package pay2park.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.login.LoginData;
import pay2park.service.login.LoginService;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    LoginService loginService;

    @GetMapping("/")
    public ResponseEntity<ResponseObject> test() {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(HttpStatus.OK, "cc", "ok"));
    }
    @GetMapping("/api/loginenduser")
    public ResponseEntity catchNewLoginEndUser(@RequestParam(value = "zlpId", defaultValue = "") String zlpID) {
        ResponseObject res = loginService.login(new LoginData(zlpID));
        return ResponseEntity.status(res.getStatus()).body(res);
    }
}
