package pay2park.model.login;

public class MerchantEmployeeResponseLoginData {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
    String userId;
    String phone;
    MerchantEmployeePermissions permissions;
}
