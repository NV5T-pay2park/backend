package pay2parkbackend.controller.payment;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pay2parkbackend.model.ResponseObject;
import pay2parkbackend.service.payment.QueryOrderService;

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
    public ResponseObject createOrder(@RequestBody Map<String,String> appTransId) throws IOException, URISyntaxException {
        var data = queryOrderService.queryOrder(appTransId);
        return
                new ResponseObject(HttpStatus.OK, "query order status successfully", data) ;
    }
}