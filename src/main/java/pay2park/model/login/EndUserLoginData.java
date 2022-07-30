package pay2park.model.login;

public class EndUserLoginData {
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


    public EndUserLoginData(String zalopayID) {
        this.zalopayID = zalopayID;
    }
}
