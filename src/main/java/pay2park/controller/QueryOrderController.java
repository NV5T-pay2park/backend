package pay2park.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pay2park.service.QueryOrderService;

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
    public JSONObject createOrder(@RequestBody Map<String,String> appTransId){
        try {
            return queryOrderService.queryOrder(appTransId);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}