package com.example.pay2parkbackend.controller;


import com.example.pay2parkbackend.model.OrderData;
import com.example.pay2parkbackend.model.ResponseOrderData;
import com.example.pay2parkbackend.service.CreateOrderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@RestController
@RequestMapping("/api/")
public class CreateOrderController {
    @Autowired
    private CreateOrderService createOrderService;

    @PostMapping("/createOrder")
    @ResponseBody
    public ResponseOrderData createOrder(@RequestBody OrderData orderData){
        try {
            return createOrderService.createOrder(orderData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

