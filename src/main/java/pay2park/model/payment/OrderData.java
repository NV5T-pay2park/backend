package pay2park.model.payment;

public class OrderData {
    private Long ticketId;
    private Long userId;
    private Long amount;

    public OrderData(Long ticketId, Long userId, Long amount) {
        this.ticketId = ticketId;
        this.userId = userId;
        this.amount = amount;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
