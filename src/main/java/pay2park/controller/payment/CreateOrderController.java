package pay2park.controller.payment;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.payment.OrderData;
import pay2park.service.payment.CreateOrderService;


import java.io.IOException;

@RestController
@RequestMapping("/api/")
public class CreateOrderController {
    @Autowired
    private CreateOrderService createOrderService;

    @PostMapping("/createOrder")
    @ResponseBody
    public ResponseObject createOrder(@RequestBody OrderData orderData) throws IOException {

        var data = createOrderService.createOrder(orderData);
        return data.getReturnCode() == 1 ?

                new ResponseObject(HttpStatus.OK, "create order successfully", data)
                :
                new ResponseObject(HttpStatus.OK, "create order failed", data);
    }
}

