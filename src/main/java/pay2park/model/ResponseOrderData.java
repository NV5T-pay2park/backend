package pay2park.model;

public class ResponseOrderData {
    private int return_code;
    private String app_trans_id;
    private String order_url;


    public ResponseOrderData(int return_code, String app_trans_id, String order_url) {
        this.return_code = return_code;
        this.app_trans_id = app_trans_id;
        this.order_url = order_url;
    }

    public int getReturn_code() {
        return return_code;
    }

    public void setReturn_code(int return_code) {
        this.return_code = return_code;
    }

    public String getApp_trans_id() {
        return app_trans_id;
    }

    public void setApp_trans_id(String app_trans_id) {
        this.app_trans_id = app_trans_id;
    }

    public String getOrder_url() {
        return order_url;
    }

    public void setOrder_url(String order_url) {
        this.order_url = order_url;
    }
}
