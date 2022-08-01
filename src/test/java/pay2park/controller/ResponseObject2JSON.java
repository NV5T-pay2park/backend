package pay2park.controller;

import net.minidev.json.JSONObject;
import pay2park.model.ResponseObject;

public class ResponseObject2JSON {
    public static JSONObject cast (ResponseObject obj) {
        JSONObject ans = new JSONObject();
        ans.put("status", obj.getStatus());
        ans.put("message", obj.getMessage());
        ans.put("data", obj.getData());
        return ans;
    }
}
