package pay2park.model.payment;

public class ResponseOrderData {
    private int returnCode;
    private String appTransId;
    private String orderUrl;
    private String zp_trans_token;

    public ResponseOrderData(int returnCode, String appTransId, String orderUrl, String zp_trans_token) {
        this.returnCode = returnCode;
        this.appTransId = appTransId;
        this.orderUrl = orderUrl;
        this.zp_trans_token = zp_trans_token;


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

    public String getZp_trans_token() {
        return zp_trans_token;
    }

    public void setZp_trans_token(String zp_trans_token) {
        this.zp_trans_token = zp_trans_token;
    }
}
