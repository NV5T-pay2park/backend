package pay2park.controller.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pay2park.model.ResponseObject;
import pay2park.service.payment.QueryOrderService;
import pay2park.service.payment.QueryPaymentUrlService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class QueryPaymentUrlController {
    @Autowired
    private QueryPaymentUrlService queryPaymentUrlService;

    @GetMapping("/queryPaymentUrl")
    @ResponseBody
    public ResponseObject createOrder(@RequestParam String appTransId) throws IOException, URISyntaxException {
        var data = queryPaymentUrlService.queryPaymentUrl(appTransId);


        return new ResponseObject(HttpStatus.OK, "query payment url successfully", data);

    }
}