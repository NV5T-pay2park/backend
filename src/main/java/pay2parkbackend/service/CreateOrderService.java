package com.example.pay2parkbackend.service;

import com.example.pay2parkbackend.model.OrderData;
import com.example.pay2parkbackend.model.ResponseOrderData;
import org.json.JSONObject;

import java.io.IOException;

public interface CreateOrderService {
    ResponseOrderData createOrder(OrderData orderData) throws IOException;
}
