package pay2park.service.payment;


import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import pay2park.model.payment.OrderData;
import pay2park.model.payment.ResponseOrderData;
import pay2park.util.crypto.HMACUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CreateOrderServiceImpl implements  CreateOrderService{
    private static Map<String, String> config = new HashMap<String, String>(){{
        put("app_id", "805");
        put("key1", "pca7SCpBItgbQnT4tKr1yY5vpow6QMZ9");
        put("key2", "82NZPr8nLJj8es3QhJOZgSVTsPwZ4gkS");
        put("endpoint", "https://sbqc-openapi.zalopay.vn/v2/create");
    }};

    public static String getCurrentTimeString(String format) {
        Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("GMT+7"));
        SimpleDateFormat fmt = new SimpleDateFormat(format);
        fmt.setCalendar(cal);
        return fmt.format(cal.getTimeInMillis());
    }
    @Override
    public ResponseOrderData createOrder(OrderData orderData) throws IOException {
        Random rand = new Random();
        final Map embed_data = new HashMap(){{

        }};

        Map<String, Object> order = new HashMap<String, Object>(){{
            put("app_id", config.get("app_id"));
            put("app_trans_id", getCurrentTimeString("yyMMdd") +"_"+ orderData.getUserId().toString() + orderData.getTicketId().toString()); // translation missing: en.docs.shared.sample_code.comments.app_trans_id
            put("app_time", System.currentTimeMillis()); // miliseconds
            put("app_user", "DicBRxUCu86qoxntyDR_VTIeTpdXF0hfRUI1q-QPVyg");
            put("amount", orderData.getAmount());
            put("description", "Pay2Park - Payment for the order #"+orderData.getUserId().toString() + orderData.getTicketId().toString());
            put("bank_code", "zalopayapp");
            put("item", "[]");
            put("embed_data", new JSONObject(embed_data).toString());
        }};
        String appTransId = order.get("app_trans_id").toString();

        // app_id +”|”+ app_trans_id +”|”+ appuser +”|”+ amount +"|" + app_time +”|”+ embed_data +"|" +item
        String data = order.get("app_id") +"|"+ order.get("app_trans_id") +"|"+ order.get("app_user") +"|"+ order.get("amount")
                +"|"+ order.get("app_time") +"|"+ order.get("embed_data") +"|"+ order.get("item");
        order.put("mac", HMACUtil.HMacHexStringEncode(HMACUtil.HMACSHA256, config.get("key1"), data));

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(config.get("endpoint"));

        List<NameValuePair> params = new ArrayList<>();
        for (Map.Entry<String, Object> e : order.entrySet()) {
            params.add(new BasicNameValuePair(e.getKey(), e.getValue().toString()));
        }

        // Content-Type: application/x-www-form-urlencoded
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
        return new ResponseOrderData( (int)result.get("return_code"),appTransId, result.get("order_url").toString(), result.get("zp_trans_token").toString());
    };
}