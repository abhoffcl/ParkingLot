package controller;

import model.Bill;
import service.strategy.BillService;

public class BillController {
    private BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }
    public Bill createBill(int ticketId,int exitGateId){
        return billService.generateBill(ticketId,exitGateId);
    }
}
