package service.strategy.billCalculation;

import model.Bill;
import model.Gate;
import model.Ticket;

import java.time.Instant;

public class SurgeBillCalculationStrategy implements BillCalculationStrategy{
    @Override
    public Bill generateBill(Ticket ticket, Gate exitGate) {
        Bill bill = new Bill();
        bill.setExitGate(exitGate);
        bill.setTicket(ticket);
        bill.setExitTime(Instant.now());
        double filledRatio = ticket.getFilledRatio();
        double durationInHours = ( Instant.now().getEpochSecond() -  ticket.getEntryTime().getEpochSecond()) / 3600.0;
        double amount = 10 + durationInHours*10;  // base + duration*hourlyRate
        double surgeAmount=0;
        if(filledRatio>=0.5 && filledRatio<0.75)
            surgeAmount=amount*0.5;
        else if(filledRatio>=0.75 && filledRatio<0.9)
            surgeAmount=amount*0.75;
        else if(filledRatio>=0.9)
            surgeAmount=amount*0.9;
        amount+=surgeAmount;
        bill.setAmount(amount);
        return bill;

    }
}
