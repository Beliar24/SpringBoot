package com.example.springbootapp.service;

import com.example.springbootapp.dao.Event;
import com.example.springbootapp.dao.Ticket;
import com.example.springbootapp.dao.User;
import com.example.springbootapp.repository.EventRepository;
import com.example.springbootapp.repository.TicketRepository;
import com.example.springbootapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TicketService {

    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;


    public TicketService(TicketRepository ticketRepository, EventRepository eventRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public Ticket createTicket(Ticket ticket, Long user_id, Long event_id){
        Optional<Event> event = eventRepository.findById(event_id);
        Optional<User> user = userRepository.findById(user_id);
        ticket.setEvent_id(event.orElse(null));
        ticket.setUser_id(user.orElse(null));
        return ticketRepository.save(ticket);
    }

    public Optional<Ticket> getTicketById(long id) {
        return ticketRepository.findById(id);
    }

    public List<Ticket> getTickets() {
        return ticketRepository.findAll().stream().toList();
    }

    public void deleteTicket(long id) {
        ticketRepository.deleteById(id);
    }
}
