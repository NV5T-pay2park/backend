package pay2park.controller.payment;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.model.payment.QueryData;
import pay2park.model.payment.ResponseOrderData;
import pay2park.model.payment.ResponseQueryData;
import pay2park.service.payment.QueryOrderService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

//@RestController
//@RequestMapping("/api/")
//@CrossOrigin
//public class QueryOrderController {
//    @Autowired
//    private QueryOrderService queryOrderService;
//
//    @PostMapping("/queryOrder")
//    @ResponseBody
//    public ResponseQueryData createOrder(@RequestBody QueryData queryData) throws IOException, URISyntaxException {
//        ResponseQueryData data = queryOrderService.queryOrder(queryData);
//        return data;
//    }
//}

@RestController
@RequestMapping(value = "/api/", method = RequestMethod.POST
        , produces = {"application/json", "application/xml"}
        ,  consumes = {"application/x-www-form-urlencoded"})
@CrossOrigin
public class QueryOrderController {
    @Autowired
    private QueryOrderService queryOrderService;

    @PostMapping("/queryOrder")
    @ResponseBody
    public ResponseQueryData createOrder(QueryData queryData) throws IOException, URISyntaxException {
        ResponseQueryData data = queryOrderService.queryOrder(queryData);
        return data;
    }
}

