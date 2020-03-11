package be.pxl.student.entity;

import java.time.Instant;
import java.time.LocalDateTime;

public class Payment {

    private int id;
    private LocalDateTime date;
    private float amount;
    private String currency;
    private String detail;
    private int accountId;
    private int counterAccountId;
    private int labelId;

    public Payment(LocalDateTime date, float amount, String currency, String detail, int accountId, int counterAccountId, int labelId) {
        this.date = date;
        this.amount = amount;
        this.currency = currency;
        this.detail = detail;
        this.accountId = accountId;
        this.counterAccountId = counterAccountId;
        this.labelId = labelId;
    }

    public int getId(){ return id; }

    public void setId(int id) { this.id = id; }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getAccountId() { return accountId; }

    public void setAccountId(int accountId) { this.accountId = accountId; }

    public int getCounterAccountId() { return counterAccountId; }

    public void setCounterAccountId(int counterAccountId) { this.counterAccountId = counterAccountId; }

    public int getLabelId() { return labelId; }

    public void setLabelId(int labelId) { this.labelId = labelId; }

    @Override
    public String toString() {
        return "{" +
                "date=" + date +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }


}
