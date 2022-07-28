package pay2park.model.payment;

public class QueryUrlData {
    private Long endUserId;
    private Long ticketId;

    public QueryUrlData(Long endUserId, Long ticketId) {
        this.endUserId = endUserId;
        this.ticketId = ticketId;
    }

    public Long getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Long endUserId) {
        this.endUserId = endUserId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
}
