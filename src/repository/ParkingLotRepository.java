package repository;

import exceptions.ParkingLotNotFoundException;
import model.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private static int idCounter=0;
    private Map<Integer, ParkingLot> parkingLotmap;

    public ParkingLotRepository() {
        this.parkingLotmap = new HashMap<>();
    }

    public ParkingLot getParkingLot(int parkingLotId){
        ParkingLot parkingLot = parkingLotmap.get(parkingLotId);
        if(parkingLot==null)
            throw new ParkingLotNotFoundException("Parking lot not found for id "+parkingLotId);
        return parkingLot;
    }
    public void putParkingLot(ParkingLot parkingLot){
        parkingLot.setId(++idCounter);
         parkingLotmap.put(parkingLot.getId(),parkingLot);

    }
}
