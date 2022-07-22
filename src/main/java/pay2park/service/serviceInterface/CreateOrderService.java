package pay2park.service.serviceInterface;

import pay2park.model.entityRequest.OrderData;
import pay2park.model.entityResponse.ResponseOrderData;

import java.io.IOException;

public interface CreateOrderService {
    ResponseOrderData createOrder(OrderData orderData) throws IOException;
}
