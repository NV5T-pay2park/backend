package pay2park.model.payment;

import javax.persistence.criteria.CriteriaBuilder;

public class OrderData {
    private Long ticketId;
    private Long userId;
    private Integer amount;

    public OrderData(Long ticketId, Long userId, Integer amount) {
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
