package service.strategy.spotAllocation;

import model.ParkingLot;
import model.ParkingSpot;
import model.Vehicle;

public interface SpotAllocationStrategy {
    public ParkingSpot allocateSpot(Vehicle vehicle,ParkingLot parkingLot);
}
