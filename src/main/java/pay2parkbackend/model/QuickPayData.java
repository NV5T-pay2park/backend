package com.example.pay2parkbackend.model;

public class QuickPayData {
    private String paymentCodeRaw;
    private Long userId;
    private Long ticketId;
    private Long amount;

    public String getPaymentCodeRaw() {
        return paymentCodeRaw;
    }

    public void setPaymentCodeRaw(String paymentCodeRaw) {
        this.paymentCodeRaw = paymentCodeRaw;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
