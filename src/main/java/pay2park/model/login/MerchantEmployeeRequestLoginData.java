package pay2park.model.login;

public class MerchantEmployeeRequestLoginData {
    private String phone = "";
    private String password = "";
    private String userName = null;

    public MerchantEmployeeRequestLoginData() {}

    public MerchantEmployeeRequestLoginData(String phone, String userName, String password) {
        this.phone = phone;
        this.userName = userName;
        this.password = password;
    }


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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
