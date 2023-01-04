package com.example.springbootapp.service;

import com.example.springbootapp.model.Ticket;
import com.example.springbootapp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Transactional
    public void createTicket(Ticket ticket) {
        ticketRepository.createTicket(ticket);
    }

    @Transactional
    public Ticket getTicket(Long id) {
        return ticketRepository.getTicket(id);
    }

    @Transactional
    public void cancelTicket(Ticket ticket) {
        ticketRepository.cancelTicket(ticket);
    }
}
