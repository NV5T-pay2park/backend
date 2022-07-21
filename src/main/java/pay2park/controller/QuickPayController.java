package pay2park.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pay2park.model.QuickPayData;
import pay2park.service.QuickPayService;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;

@RestController
@RequestMapping("/api/")
public class QuickPayController {
    @Autowired
    private QuickPayService quickPayService;

    @PostMapping("/quickPay")
    @ResponseBody
    public JSONObject createOrder(@RequestBody QuickPayData quickPayData){
        try {
            return quickPayService.quickPay(quickPayData);
        } catch (IOException | IllegalBlockSizeException | BadPaddingException | InvalidKeySpecException | InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }
}

