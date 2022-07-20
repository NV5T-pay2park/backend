package com.example.pay2parkbackend.service.payment;



import com.example.pay2parkbackend.model.payment.OrderData;
import com.example.pay2parkbackend.model.payment.ResponseOrderData;

import java.io.IOException;

public interface CreateOrderService {
    ResponseOrderData createOrder(OrderData orderData) throws IOException;
}
