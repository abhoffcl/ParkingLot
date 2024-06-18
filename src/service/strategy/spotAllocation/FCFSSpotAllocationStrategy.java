package service.strategy.spotAllocation;


import exceptions.ParkingSpotNotAvailableException;
import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingSpot;
import model.Vehicle;
import model.status.ParkingSpotStatus;

import java.util.List;

public class FCFSSpotAllocationStrategy implements SpotAllocationStrategy{
    @Override
    public ParkingSpot allocateSpot(Vehicle vehicle, ParkingLot parkingLot) {
        for(ParkingFloor parkingFloor:parkingLot.getParkingFloors()){
            for(ParkingSpot parkingSpot: parkingFloor.getParkingSpots()){
                if(parkingSpot.getParkingSpotStatus()==ParkingSpotStatus.AVAILABLE &&
                        parkingSpot.getVehicleType()==vehicle.getVehicleType())
                    return parkingSpot;
            }
        }

       throw new ParkingSpotNotAvailableException("No parking spot available");
    }
}
