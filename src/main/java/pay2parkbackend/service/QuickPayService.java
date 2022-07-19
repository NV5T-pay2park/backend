package com.example.pay2parkbackend.service;

import com.example.pay2parkbackend.model.QuickPayData;
import org.json.JSONObject;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;

public interface QuickPayService {
    JSONObject quickPay(QuickPayData quickPayData) throws IOException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, InvalidKeyException;
}