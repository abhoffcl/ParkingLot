package service.strategy.billCalculation;

import model.Bill;
import model.Gate;
import model.Ticket;

import java.time.Instant;

public class FlatRateBillCalculationStrategy implements BillCalculationStrategy{
    @Override
    public Bill generateBill(Ticket ticket, Gate exitGate) {

        Bill bill = new Bill();
        bill.setAmount(100);
        bill.setExitGate(exitGate);
        bill.setTicket(ticket);
        bill.setExitTime(Instant.now());
        return bill;
    }
}
