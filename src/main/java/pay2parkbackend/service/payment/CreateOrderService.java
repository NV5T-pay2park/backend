package pay2parkbackend.service.payment;





import pay2parkbackend.model.payment.OrderData;
import pay2parkbackend.model.payment.ResponseOrderData;

import java.io.IOException;

public interface CreateOrderService {
    ResponseOrderData createOrder(OrderData orderData) throws IOException;
}
