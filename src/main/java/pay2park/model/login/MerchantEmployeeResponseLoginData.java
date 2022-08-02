package pay2park.model.login;

public class MerchantEmployeeResponseLoginData {
    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public MerchantEmployeePermissions getPermissions() {
        return permissions;
    }

    public void setPermissions(MerchantEmployeePermissions permissions) {
        this.permissions = permissions;
    }

    String userName;
    int userId;


    int merchantId;
    String phone;
    MerchantEmployeePermissions permissions;
}
