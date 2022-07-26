package pay2park.controller.payment;



import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.payment.OrderData;
import pay2park.model.payment.ResponseOrderData;
import pay2park.service.payment.CreateOrderService;


import java.io.IOException;

@RestController
@RequestMapping("/api/")
public class CreateOrderController {
    @Autowired
    private CreateOrderService createOrderService;

    @PostMapping(value = "/createOrder")
    @ResponseBody
    public ResponseObject createOrder(@RequestBody OrderData orderData) throws IOException {

        ResponseOrderData data = createOrderService.createOrder(orderData);
        return data.getReturnCode() == 1 ?

                new ResponseObject(HttpStatus.OK, "create order successfully", data)
                :
                new ResponseObject(HttpStatus.OK, "create order failed", data);
    }
    @GetMapping(value = "/getCreateOrder")
    @ResponseBody
    public ResponseObject getCreateOrder(@RequestParam Long userId, @RequestParam Long ticketId, @RequestParam Long amount) throws IOException {
        OrderData orderData = new OrderData(userId, ticketId, amount);
        ResponseOrderData data = createOrderService.createOrder(orderData);
        return data.getReturnCode() == 1 ?

                new ResponseObject(HttpStatus.OK, "create order successfully", data)
                :
                new ResponseObject(HttpStatus.OK, "create order failed", data);
    }
}


// oke for checkout call http

//@RestController
//@RequestMapping(value = "/api/", method = RequestMethod.POST
//        , produces = {"application/json", "application/xml"}
//        ,  consumes = {"application/x-www-form-urlencoded"})
//public class CreateOrderController {
//    @Autowired
//    private CreateOrderService createOrderService;
//
//    @PostMapping(value = "/createOrder")
//    @ResponseBody
//    public ResponseObject createOrder(OrderData orderData) throws IOException {
//
//        var data = createOrderService.createOrder(orderData);
//        return data.getReturnCode() == 1 ?
//
//                new ResponseObject(HttpStatus.OK, "create order successfully", data)
//                :
//                new ResponseObject(HttpStatus.OK, "create order failed", data);
//    }
//}

