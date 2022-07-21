package pay2parkbackend.model.payment;

public class ResponseQueryData {
    private int returnCode;

    public ResponseQueryData(int returnCode) {
        this.returnCode = returnCode;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }
}
