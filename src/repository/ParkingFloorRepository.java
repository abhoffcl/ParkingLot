package repository;

import exceptions.ParkingFloorNotFoundException;
import model.ParkingFloor;
import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {
    private static int idCounter=0;
    private Map<Integer, ParkingFloor> parkingfloormap;

    public ParkingFloorRepository() {
        this.parkingfloormap = new HashMap<>();
    }

    public ParkingFloor getParkingfloor(int parkingfloorId){
        ParkingFloor parkingFloor=parkingfloormap.get(parkingfloorId);
        if(parkingFloor==null)
            throw new ParkingFloorNotFoundException("Parking floor not found for id "+parkingfloorId);
        return parkingFloor;
    }
    public void putParkingfloor(ParkingFloor parkingfloor){
        parkingfloor.setId(++idCounter);
        parkingfloormap.put(parkingfloor.getId(),parkingfloor);

    }
}
