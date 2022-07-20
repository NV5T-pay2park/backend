package pay2parkbackend.service.payment;
import pay2parkbackend.model.payment.ResponseQueryData;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public interface QueryOrderService {
    ResponseQueryData queryOrder(Map<String,String> appTransId) throws IOException, URISyntaxException;
}