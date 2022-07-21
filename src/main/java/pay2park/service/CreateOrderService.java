package pay2park.service;

import pay2park.model.OrderData;
import pay2park.model.ResponseOrderData;

import java.io.IOException;

public interface CreateOrderService {
    ResponseOrderData createOrder(OrderData orderData) throws IOException;
}
