package pay2park.model.login;

public class LoginData {
    String zalopayID;

    int endUserID;

    public String getZalopayID() {
        return zalopayID;
    }

    public void setZalopayID(String zalopayID) {
        this.zalopayID = zalopayID;
    }

    public int getEndUserID() {
        return endUserID;
    }

    public void setEndUserID(int endUserID) {
        this.endUserID = endUserID;
    }


    public LoginData(String zalopayID) {
        this.zalopayID = zalopayID;
    }
}
