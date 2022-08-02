package pay2park.model.login;

public class EndUserLoginData {
    String zalopayID;

    int endUserID;
    String firstName;
    String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


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


    public EndUserLoginData(String zalopayID, String firstName, String lastName) {
        this.zalopayID = zalopayID;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
