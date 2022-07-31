package pay2park.model.payment;

public class ResponseOrderData {
    private int returnCode;
    private String appTransId;
    private String orderUrl;
    private String zpTransToken;

    public ResponseOrderData(int returnCode, String appTransId, String orderUrl, String zpTransToken) {
        this.returnCode = returnCode;
        this.appTransId = appTransId;
        this.orderUrl = orderUrl;
        this.zpTransToken = zpTransToken;
    }

    public ResponseOrderData() {
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getAppTransId() {
        return appTransId;
    }

    public void setAppTransId(String appTransId) {
        this.appTransId = appTransId;
    }

    public String getOrderUrl() {
        return orderUrl;
    }

    public void setOrderUrl(String orderUrl) {
        this.orderUrl = orderUrl;
    }

    public String getZpTransToken() {
        return zpTransToken;
    }

    public void setZpTransToken(String zpTransToken) {
        this.zpTransToken = zpTransToken;
    }
}
