package model;

import model.status.ParkingSpotStatus;

public class ParkingSpot extends BaseModel{
    private int spotNumber;
    private ParkingSpotStatus parkingSpotStatus;
    private Vehicle vehicle;

    private VehicleType vehicleType;
    public ParkingSpot() {
    }

    public ParkingSpot(int spotNumber, ParkingSpotStatus parkingSpotStatus, Vehicle vehicle, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.parkingSpotStatus = parkingSpotStatus;
        this.vehicle = vehicle;
        this.vehicleType = vehicleType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}

