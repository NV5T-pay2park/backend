package pay2park.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.login.EndUserLoginData;
import pay2park.service.login.EndUserLoginService;

@RestController
@CrossOrigin
public class EndUserLoginController {
    @Autowired
    EndUserLoginService loginService;

    @GetMapping("/")
    public ResponseEntity<ResponseObject> test() {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject(HttpStatus.OK, "cc", "ok"));
    }
    @GetMapping("/api/loginenduser")
    public ResponseEntity<ResponseObject> catchNewLoginEndUser(@RequestParam(value = "zlpId", defaultValue = "") String zlpID) {
        ResponseObject res = loginService.login(new EndUserLoginData(zlpID));
        return ResponseEntity.status(res.getStatus()).body(res);
    }
}
