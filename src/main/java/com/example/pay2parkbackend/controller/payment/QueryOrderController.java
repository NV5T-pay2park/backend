package com.example.pay2parkbackend.controller.payment;

import com.example.pay2parkbackend.model.ResponseObject;
import com.example.pay2parkbackend.service.payment.QueryOrderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class QueryOrderController {
    @Autowired
    private QueryOrderService queryOrderService;

    @PostMapping("/queryOrder")
    @ResponseBody
    public ResponseEntity<ResponseObject> createOrder(@RequestBody Map<String,String> appTransId) throws IOException, URISyntaxException {
        var data = queryOrderService.queryOrder(appTransId);
        return  ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "query order status successfully", data)) ;
    }
}