package controller;

import exceptions.InvalidInputException;
import model.*;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;
import service.strategy.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public  Ticket createTicket(Vehicle vehicle, int parkingLotId, int entryGateId){
        if(parkingLotId<0 || entryGateId<0)
            throw new InvalidInputException("Enter valid details");
      Ticket ticket =ticketService.generateTicket(vehicle,parkingLotId,entryGateId);
      return ticket;
    }
}
