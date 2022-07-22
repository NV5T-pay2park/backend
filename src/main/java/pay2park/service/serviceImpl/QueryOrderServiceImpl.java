package pay2park.service.serviceImpl;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import pay2park.service.serviceInterface.QueryOrderService;
import pay2park.util.crypto.HMACUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QueryOrderServiceImpl implements QueryOrderService {
    private static final Map<String, String> config = new HashMap<String, String>(){{
        put("app_id", "999888");
        put("key1", "BuwHniWv76aTdSaHlBoY1j6hWFDp7zG8");
        put("key2", "4K0itMD70mzCdEycINM2ZwookqBJgPcD");
        put("endpoint", "https://sb-openapi.zalopay.vn/v2/query");
    }};

    public JSONObject queryOrder(Map<String,String> appTransId) throws URISyntaxException, IOException {
        String app_trans_id = appTransId.get("app_trans_id");  // Input your app_trans_id
        String data = config.get("app_id") +"|"+ app_trans_id  +"|"+ config.get("key1"); // appid|app_trans_id|key1
        String mac = HMACUtil.HMacHexStringEncode(HMACUtil.HMACSHA256, config.get("key1"), data);

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("app_id", config.get("app_id")));
        params.add(new BasicNameValuePair("app_trans_id", app_trans_id));
        params.add(new BasicNameValuePair("mac", mac));

        URIBuilder uri = new URIBuilder(config.get("endpoint"));
        uri.addParameters(params);

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(uri.build());
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
