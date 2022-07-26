package pay2park.service.payment;
import pay2park.model.payment.QueryData;
import pay2park.model.payment.ResponseQueryData;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public interface QueryOrderService {
    ResponseQueryData queryOrder(QueryData queryData) throws IOException, URISyntaxException;
}