package model;

import model.status.PaymentStatus;

public class Payment extends BaseModel{
    private double amount;
    private Bill bill;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private String referenceId;

    public Payment(double amount, Bill bill, PaymentMode paymentMode, PaymentStatus paymentStatus, String referenceId) {
        this.amount = amount;
        this.bill = bill;
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
        this.referenceId = referenceId;
    }

    public Payment() {
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
}
