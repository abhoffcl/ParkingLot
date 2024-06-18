package service.strategy;

import model.*;
import model.status.ParkingSpotStatus;
import repository.BillRepository;
import repository.GateRepository;
import repository.ParkingLotRepository;
import repository.TicketRepository;
import service.strategy.spotAllocation.SpotAllocationStrategy;

import java.time.Instant;

public class TicketService {
    private TicketRepository ticketRepository;
    private BillRepository billRepository;
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;
    private SpotAllocationStrategy spotAllocationStrategy;

    public TicketService(TicketRepository ticketRepository, BillRepository billRepository, ParkingLotRepository parkingLotRepository, GateRepository gateRepository, SpotAllocationStrategy spotAllocationStrategy) {
        this.ticketRepository = ticketRepository;
        this.billRepository = billRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
        this.spotAllocationStrategy = spotAllocationStrategy;
    }

    public Ticket generateTicket(Vehicle vehicle, int parkingLotId, int entryGateId){
        ParkingLot parkingLot =parkingLotRepository.getParkingLot(parkingLotId);
        Gate entryGate = gateRepository.getGate(entryGateId);
        ParkingSpot parkingSpot = spotAllocationStrategy.allocateSpot(vehicle,parkingLot);
        int filledRatio =
                (ticketRepository.getTotalTicketsGenerated()-billRepository.getTotalBillsGenerated())/ parkingLot.getCapacity();
        Ticket ticket = new Ticket(Instant.now(),vehicle,parkingSpot,entryGate,filledRatio);
        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        parkingSpot.setVehicle(vehicle);
        // update the repository
        return  ticketRepository.putTicket(ticket);
    }
}
