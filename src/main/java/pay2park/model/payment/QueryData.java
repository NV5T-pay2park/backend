package pay2park.model.payment;

public class QueryData {
    private String appTransId;

    public QueryData(String appTransId) {
        this.appTransId = appTransId;
    }

    public String getAppTransId() {
        return appTransId;
    }

    public void setAppTransId(String appTransId) {
        this.appTransId = appTransId;
    }
}
