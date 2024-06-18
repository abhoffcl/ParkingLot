package repository;

import exceptions.BillNotFoundException;
import model.Bill;

import java.util.HashMap;
import java.util.Map;

public class BillRepository {
    private static int idCounter=0;
    private Map<Integer, Bill> billmap;

    public BillRepository() {
        this.billmap = new HashMap<>();
    }

    public Bill getBill(int billId){
        Bill bill = billmap.get(billId);
        if(bill==null)
            throw new BillNotFoundException("Bill not found for id "+billId);


        return bill;
    }
    public void putBill(Bill Bill){
        Bill.setId(++idCounter);
        billmap.put(Bill.getId(),Bill);

    }
    public int getTotalBillsGenerated(){
        return billmap.size();
    }
}
