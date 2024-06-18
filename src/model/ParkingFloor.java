package model;

import model.status.ParkingfloorStatus;

import java.util.List;

public class ParkingFloor extends BaseModel {
    private int floorNumber;
    private List<ParkingSpot> parkingSpots;
    private ParkingfloorStatus parkingfloorStatus;
    private Gate entryGate;
    private Gate exitGate;

    public ParkingFloor() {
    }

    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpots, ParkingfloorStatus parkingfloorStatus, Gate entryGate, Gate exitGate) {
        this.floorNumber = floorNumber;
        this.parkingSpots = parkingSpots;
        this.parkingfloorStatus = parkingfloorStatus;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public ParkingfloorStatus getParkingfloorStatus() {
        return parkingfloorStatus;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public void setParkingfloorStatus(ParkingfloorStatus parkingfloorStatus) {
        this.parkingfloorStatus = parkingfloorStatus;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

}
