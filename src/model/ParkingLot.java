package model;

import model.status.ParkingLotStatus;
import service.strategy.billCalculation.BillCalculationStrategy;
import service.strategy.spotAllocation.SpotAllocationStrategy;

import java.util.List;

public class ParkingLot extends BaseModel {
    private String name;
    private String location;
    private ParkingLotStatus status;
    private List<ParkingFloor> parkingFloors;
    private  int capacity;
    private List<VehicleType>vehicleTypeSupported;
    private SpotAllocationStrategy spotAllocationStrategy;
    private BillCalculationStrategy billCalculatorStrategy;

    public ParkingLot() {
    }

    public ParkingLot(String name, String location, ParkingLotStatus status, int capacity, SpotAllocationStrategy spotAllocationStrategy) {
        this.name = name;
        this.location = location;
        this.status = status;
        this.capacity = capacity;
        this.spotAllocationStrategy = spotAllocationStrategy;
    }
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public ParkingLotStatus getStatus() {
        return status;
    }

    public int getCapacity() {
        return capacity;
    }

    public SpotAllocationStrategy getSpotAllocationStrategy() {
        return spotAllocationStrategy;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public BillCalculationStrategy getBillCalculatorStrategy() {
        return billCalculatorStrategy;
    }

    public void setSpotAllocationStrategy(SpotAllocationStrategy spotAllocationStrategy) {
        this.spotAllocationStrategy = spotAllocationStrategy;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public void setBillCalculatorStrategy(BillCalculationStrategy billCalculatorStrategy) {
        this.billCalculatorStrategy = billCalculatorStrategy;
    }

    public List<VehicleType> getVehicleTypeSupported() {
        return vehicleTypeSupported;
    }

    public void setVehicleTypeSupported(List<VehicleType> vehicleTypeSupported) {
        this.vehicleTypeSupported = vehicleTypeSupported;
    }
}
