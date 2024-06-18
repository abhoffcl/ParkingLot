package repository;

import exceptions.TicketNotFoundException;
import model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private static int idCounter=0;
    private Map<Integer, Ticket> ticketmap;

    public TicketRepository() {
        this.ticketmap = new HashMap<>();
    }

    public Ticket getTicket(int ticketId){
        Ticket ticket = ticketmap.get(ticketId);
        if(ticket==null)
            throw new TicketNotFoundException("Ticket not found for id "+ticketId);
    return ticket;
    }
    public Ticket putTicket(Ticket Ticket){
        Ticket.setId(++idCounter);
        ticketmap.put(Ticket.getId(),Ticket);
        return ticketmap.get(idCounter);

    }
    public int getTotalTicketsGenerated(){
        return ticketmap.size();
    }
}

