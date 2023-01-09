package com.example.springbootapp.service;

import com.example.springbootapp.dao.Ticket;
import com.example.springbootapp.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;


    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public void createTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }

    public Ticket getTicketById(long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.orElse(null);
    }

    public List<Ticket> getTickets() {
        return ticketRepository.findAll().stream().toList();
    }

    public Ticket deleteTicket(long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        Ticket tmp = ticket.orElse(null);
        assert tmp != null;
        ticketRepository.delete(tmp);
        return tmp;
    }
}
