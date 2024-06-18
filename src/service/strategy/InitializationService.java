package service.strategy;

import model.*;
import model.status.GateStatus;
import model.status.ParkingLotStatus;
import model.status.ParkingSpotStatus;
import model.status.ParkingfloorStatus;
import repository.GateRepository;
import repository.ParkingFloorRepository;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;

public class InitializationService {
    private ParkingLotRepository parkingLotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private GateRepository gateRepository;

    public InitializationService(ParkingLotRepository parkingLotRepository, ParkingFloorRepository parkingFloorRepository, ParkingSpotRepository parkingSpotRepository, GateRepository gateRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.gateRepository = gateRepository;
    }

    public ParkingLot init(){
        System.out.println("-----Starting initialization-----");

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCapacity(100);
        parkingLot.setName("Radhey Parking Centre");
        parkingLot.setLocation("Arizona Mall,22 Street,Dehradun");
        parkingLot.setStatus(ParkingLotStatus.OPEN);
        parkingLot.setVehicleTypeSupported(List.of(VehicleType.FOUR_WHEELER,VehicleType.TWO_WHEELER));
        List<ParkingFloor>parkingFloors=new ArrayList<>();

        for(int i=1;i<=10;i++){
            ParkingFloor parkingFloor =new ParkingFloor();
            parkingFloor.setFloorNumber(i);
            parkingFloor.setParkingfloorStatus(ParkingfloorStatus.AVAILABLE);

            List<ParkingSpot> parkingSpots= new ArrayList<>();
            for(int j=1;j<=10;j++){
                ParkingSpot parkingSpot=new ParkingSpot();
                parkingSpot.setSpotNumber((i*100)+j);
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
                parkingSpot.setVehicle(null);
                parkingSpot.setVehicleType(VehicleType.FOUR_WHEELER);
                parkingSpotRepository.putParkingspot(parkingSpot);
                parkingSpots.add(parkingSpot);
            }
            parkingFloor.setParkingSpots(parkingSpots);
            Gate entryGate = new Gate();
            entryGate.setGateNumber((i*100)+1);
            entryGate.setOperator("operator"+i+"1");
            entryGate.setGateStatus(GateStatus.OPEN);
            entryGate.setGateType(GateType.ENTRY);
            gateRepository.putGate(entryGate);
            parkingFloor.setEntryGate(entryGate);
            Gate exitGate = new Gate();
            exitGate.setGateNumber((i*100)+2);
            exitGate.setOperator("operator"+i+"2");
            exitGate.setGateType(GateType.EXIT);
            exitGate.setGateStatus(GateStatus.OPEN);
            gateRepository.putGate(exitGate);
            parkingFloor.setExitGate(exitGate);
            parkingFloorRepository.putParkingfloor(parkingFloor);
            parkingFloors.add(parkingFloor);

        }
        parkingLot.setParkingFloors(parkingFloors);
        parkingLotRepository.putParkingLot(parkingLot);
        System.out.println("-----Initialization completed-------");
        return parkingLotRepository.getParkingLot(1);
    }

}
