package pay2park.model.payment;

public class ResponseQueryData {
    private int returnCode;

    private String url;

    public ResponseQueryData(int returnCode, String url) {

        this.returnCode = returnCode;
        this.url = url;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
