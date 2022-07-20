package com.example.pay2parkbackend.controller.payment;


import com.example.pay2parkbackend.model.ResponseObject;
import com.example.pay2parkbackend.model.payment.OrderData;
import com.example.pay2parkbackend.model.payment.ResponseOrderData;
import com.example.pay2parkbackend.service.payment.CreateOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@RestController
@RequestMapping("/api/")
public class CreateOrderController {
    @Autowired
    private CreateOrderService createOrderService;

    @PostMapping("/createOrder")
    @ResponseBody
    public ResponseEntity<ResponseObject> createOrder(@RequestBody OrderData orderData) throws IOException {

        var data = createOrderService.createOrder(orderData);
        return  ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "create new order successfully", data)) ;
    }
}

