package pay2park.model.checkinout;

public class CheckOutData {
    Long ticketID;
    int endUserID;

    public CheckOutData(Long ticketID, int endUserID) {
        this.ticketID = ticketID;
        this.endUserID = endUserID;
    }

    public Long getTicketID() {
        return ticketID;
    }

    public void setTicketID(Long ticketID) {
        this.ticketID = ticketID;
    }

    public int getEndUserID() {
        return endUserID;
    }

    public void setEndUserID(int endUserID) {
        this.endUserID = endUserID;
    }
}
