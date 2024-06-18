package service.strategy.billCalculation;

import model.Bill;
import model.Gate;
import model.Ticket;

import java.time.Instant;

public class HourlyRateBillCalculationStrategy implements BillCalculationStrategy{
    @Override
    public Bill generateBill(Ticket ticket, Gate exitGate) {
        Bill bill = new Bill();
        bill.setExitGate(exitGate);
        bill.setTicket(ticket);
        bill.setExitTime(Instant.now());
        double durationInHours = ( Instant.now().getEpochSecond() -  ticket.getEntryTime().getEpochSecond()) / 3600.0;
        double amount = 10 + durationInHours*10;  // base + duration*hourlyRate
        bill.setAmount(amount);
        return bill;

    }
}
