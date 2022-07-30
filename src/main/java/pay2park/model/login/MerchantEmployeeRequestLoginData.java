package pay2park.model.login;

public class MerchantEmployeeRequestLoginData {
    private String phone;
    private String password;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public  String getPhone() {
        return phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public MerchantEmployeeRequestLoginData() {}

    public MerchantEmployeeRequestLoginData(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }
}
