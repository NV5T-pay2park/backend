package pay2park.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pay2park.model.OrderData;
import pay2park.model.ResponseOrderData;
import pay2park.service.CreateOrderService;


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

