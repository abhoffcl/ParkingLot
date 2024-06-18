package service.strategy.spotAllocation;

import exceptions.ParkingSpotNotAvailableException;
import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingSpot;
import model.Vehicle;
import model.status.ParkingSpotStatus;

import java.util.ArrayList;
import java.util.List;

public class RandomSpotAllocationStrategy implements SpotAllocationStrategy {
    @Override
    public ParkingSpot allocateSpot(Vehicle vehicle,ParkingLot parkingLot) {
        List<List<ParkingSpot>>parkingSpotMatrix=new ArrayList<>();
        for(ParkingFloor parkingFloor:parkingLot.getParkingFloors()){
            parkingSpotMatrix.add(parkingFloor.getParkingSpots());             // add floor spots to matrix
            for(ParkingSpot parkingSpot: parkingFloor.getParkingSpots()){
                if(!(parkingSpot.getParkingSpotStatus()== ParkingSpotStatus.AVAILABLE &&
                        parkingSpot.getVehicleType()==vehicle.getVehicleType()))
                    throw new ParkingSpotNotAvailableException("No parking spot available");
            }
        }
        int rows= parkingSpotMatrix.size(),cols=parkingSpotMatrix.get(0).size();
        int randomRow=(int) (Math.random() * rows);
        int randomCol =(int) (Math.random() * cols);
        return parkingSpotMatrix.get(randomRow).get(randomCol);

    }
}
