package model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Ticket extends BaseModel {
    private Instant entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Gate entryGate;
    private double filledRatio;

    public Ticket() {
    }


    public Ticket(Instant entryTime, Vehicle vehicle, ParkingSpot parkingSpot, Gate entryGate, double filledRatio) {
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryGate = entryGate;
        this.filledRatio = filledRatio;
    }

    public Instant getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setEntryTime(Instant entryTime) {
        this.entryTime = entryTime;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public double getFilledRatio() {
        return filledRatio;
    }

    public void setFilledRatio(double filledRatio) {
        this.filledRatio = filledRatio;
    }

    @Override
    public String toString() {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(entryTime, ZoneId.systemDefault());
        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Format the LocalDateTime to a human-readable string
        String formattedTime = localDateTime.format(formatter);

        return "Ticket{" +
                "ticketId=" +this.getId()+
                ", entryTime=" + formattedTime +
                ", vehicleNo=" + vehicle.getVehicleNumber() +
                ", parkingSpotNo=" + parkingSpot.getSpotNumber() +
                ", entryGateNo=" + entryGate.getGateNumber() +
                ", filledRatio=" + filledRatio +
                '}';
    }
}

