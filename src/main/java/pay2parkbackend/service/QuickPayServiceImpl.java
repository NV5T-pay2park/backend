package com.example.pay2parkbackend.service;

import com.example.pay2parkbackend.Pay2parkBackendApplication;
import com.example.pay2parkbackend.model.QuickPayData;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import util.crypto.HMACUtil;
import util.crypto.RSAUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.spec.InvalidKeySpecException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;

@Service
public class QuickPayServiceImpl implements QuickPayService{
    private static Logger logger = Logger.getLogger(Pay2parkBackendApplication.class.getName());

    private static Map<String, String> config = new HashMap<String, String>(){{
        put("app_id", "999888");
        put("key1", "BuwHniWv76aTdSaHlBoY1j6hWFDp7zG8");
        put("key2", "4K0itMD70mzCdEycINM2ZwookqBJgPcD");
        put("endpoint", "https://sb-openapi.zalopay.vn/v2/quick_pay");
        put("publicKey", "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAPPoKpOBhOBt413fEQMDSIWI5Hsetfk6syK6R6YILMSru08dzh3fEsB7/DfoNU4Kg1+eX/XcQSMP830zXBYrk1cCAwEAAQ==");
    }};

    private static String getCurrentTimeString(String format) {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT+7"));
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        fmt.setCalendar(cal);
        return fmt.format(cal.getTimeInMillis());
    }
    @Override
    public JSONObject quickPay(QuickPayData quickPayData) throws IOException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, InvalidKeyException {
        final Map embed_data = new HashMap(){{

        }};

        final Map[] item = {
                new HashMap(){{

                }}
        };

        final String paymentCodeRaw = quickPayData.getPaymentCodeRaw(); // được scan từ ứng dụng ZaloPay bởi thiết bị đầu cuối của Merchant

        Map<String, Object> order = new HashMap<String, Object>(){{
            put("app_id", config.get("app_id"));
            put("app_trans_id", getCurrentTimeString("yyMMdd") +"_"+ quickPayData.getUserId().toString() + quickPayData.getTicketId().toString()); // translation missing: vi.docs.shared.sample_code.comments.app_trans_id
            put("app_time", System.currentTimeMillis()); // miliseconds
            put("app_user", "demo");
            put("amount", quickPayData.getAmount());
            put("description", "ZaloPay Intergration Demo");
            put("item", "[]");
            put("embed_data", new JSONObject(embed_data).toString());
            put("userip", "127.0.0.1");
            put("payment_code", RSAUtil.encrypt(config.get("publicKey"), paymentCodeRaw));
        }};

        // app_id +”|”+ app_trans_id +”|”+ app_user +”|”+ amount +"|" + app_time +”|”+ embed_data +"|" +item
        String data = order.get("app_id") +"|"+ order.get("app_trans_id") +"|"+ order.get("app_user") +"|"+ order.get("amount")
                +"|"+ order.get("app_time") +"|"+ order.get("embed_data") +"|"+ order.get("item") +"|"+ paymentCodeRaw;
        order.put("mac", HMACUtil.HMacHexStringEncode(HMACUtil.HMACSHA256, config.get("key1"), data));

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(config.get("endpoint"));

        List<NameValuePair> params = new ArrayList<>();
        for (Map.Entry<String, Object> e : order.entrySet()) {
            params.add(new BasicNameValuePair(e.getKey(), e.getValue().toString()));
        }

        post.setEntity(new UrlEncodedFormEntity(params));

        CloseableHttpResponse res = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(res.getEntity().getContent()));
        StringBuilder resultJsonStr = new StringBuilder();
        String line;

        while ((line = rd.readLine()) != null) {
            resultJsonStr.append(line);
        }

        JSONObject result = new JSONObject(resultJsonStr.toString());
        for (String key : result.keySet()) {
            System.out.format("%s = %s\n", key, result.get(key));
        }
        return result;
    }
}
