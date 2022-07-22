package pay2parkbackend.model.payment;

public class ResponseOrderData {
    private int returnCode;
    private String appTransId;
    private String orderUrl;

    public ResponseOrderData(int returnCode, String appTransId, String orderUrl) {
        this.returnCode = returnCode;
        this.appTransId = appTransId;
        this.orderUrl = orderUrl;
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
}
