package model;

import model.status.BillStatus;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Bill extends BaseModel {
    private Ticket ticket;
    private double amount;
    private Gate exitGate;
    private Instant exitTime;
    private BillStatus billStatus;

    public Bill(Ticket ticket, double amount, Gate exitGate, Instant exitTime, BillStatus billStatus) {
        this.ticket = ticket;
        this.amount = amount;
        this.exitGate = exitGate;
        this.exitTime = exitTime;
        this.billStatus = billStatus;
    }

    public Bill() {
    }

    public Ticket getTicket() {
        return ticket;
    }

    public double getAmount() {
        return amount;
    }

    public Gate getExitGate() {
        return exitGate;
    }
    public Instant getExitTime() {
        return exitTime;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public void setExitTime(Instant exitTime) {
        this.exitTime = exitTime;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    @Override
    public String toString() {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(exitTime, ZoneId.systemDefault());
        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Format the LocalDateTime to a human-readable string
        String formattedTime = localDateTime.format(formatter);
        return "Bill{" +
                "ticketId=" + ticket.getId() +
                ", amount=" + amount +
                ", exitGateNo=" + exitGate.getGateNumber() +
                ", exitTime=" + formattedTime +
                ", billStatus=" + billStatus +
                '}';
    }
}
