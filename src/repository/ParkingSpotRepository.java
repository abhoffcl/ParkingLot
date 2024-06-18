package repository;

import exceptions.ParkingSpotNotFoundException;
import model.ParkingSpot;
import java.util.HashMap;
import java.util.Map;

public class ParkingSpotRepository {
    private static int idCounter=0;
    private Map<Integer, ParkingSpot> parkingspotmap;

    public ParkingSpotRepository() {
        this.parkingspotmap = new HashMap<>();
    }

    public ParkingSpot getParkingspot(int parkingspotId){
        ParkingSpot parkingSpot= parkingspotmap.get(parkingspotId);
        if(parkingSpot==null)
            throw new ParkingSpotNotFoundException("Parking spot not found for id"+ parkingspotId);
        return parkingSpot;
    }
    public void putParkingspot(ParkingSpot parkingspot){
        parkingspot.setId(++idCounter);
        parkingspotmap.put(parkingspot.getId(),parkingspot);

    }
}
