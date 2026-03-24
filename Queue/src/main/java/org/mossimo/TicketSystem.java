package org.mossimo;

import java.util.PriorityQueue;

public class TicketSystem {
    private PriorityQueue<Ticket> tickets;

    public TicketSystem() {
        this.tickets = new PriorityQueue<>(new Ticket.PriorityCopmarator());
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public PriorityQueue<Ticket> getTickets() {
        return tickets;
    }
}
