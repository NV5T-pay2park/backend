package pay2park.service;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public interface QueryOrderService {
    JSONObject queryOrder(Map<String,String> appTransId) throws IOException, URISyntaxException;
}