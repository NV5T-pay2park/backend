package pay2parkbackend.model.payment;

public class ResponseQueryData {
    private int return_code;

    public ResponseQueryData(int return_code) {
        this.return_code = return_code;
    }

    public int getReturn_code() {
        return return_code;
    }

    public void setReturn_code(int return_code) {
        this.return_code = return_code;
    }
}
