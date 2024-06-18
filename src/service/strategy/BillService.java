package service.strategy;

import model.Bill;
import model.Gate;
import model.Ticket;
import repository.BillRepository;
import repository.GateRepository;
import repository.TicketRepository;
import service.strategy.billCalculation.BillCalculationStrategy;

public class BillService {
    private TicketRepository ticketRepository;
    private BillRepository billRepository;
    private  BillCalculationStrategy billCalculationStrategy;
    private GateRepository gateRepository;


    public BillService(TicketRepository ticketRepository, BillRepository billRepository, BillCalculationStrategy billCalculationStrategy, GateRepository gateRepository) {
        this.ticketRepository = ticketRepository;
        this.billRepository = billRepository;
        this.billCalculationStrategy = billCalculationStrategy;
        this.gateRepository = gateRepository;
    }

    public Bill generateBill(int  ticketId , int exitGateId){
        Bill bill= billCalculationStrategy.
                generateBill(ticketRepository.getTicket(ticketId),gateRepository.getGate(exitGateId));

        return bill;
    }

}
