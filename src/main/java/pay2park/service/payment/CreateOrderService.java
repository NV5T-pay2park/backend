package pay2park.service.payment;


import pay2park.model.payment.OrderData;
import pay2park.model.payment.ResponseOrderData;

import java.io.IOException;

public interface CreateOrderService {
    ResponseOrderData createOrder(OrderData orderData) throws IOException;
}
