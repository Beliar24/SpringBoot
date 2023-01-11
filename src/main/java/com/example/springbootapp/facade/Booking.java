package com.example.springbootapp.facade;

import com.example.springbootapp.dao.Event;
import com.example.springbootapp.dao.Ticket;
import com.example.springbootapp.dao.User;
import com.example.springbootapp.service.EventService;
import com.example.springbootapp.service.TicketService;
import com.example.springbootapp.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class Booking implements Facade{

    private final UserService userService;

    private final EventService eventService;

    private final TicketService ticketService;

    public Booking(UserService userService, EventService eventService, TicketService ticketService) {
        this.userService = userService;
        this.eventService = eventService;
        this.ticketService = ticketService;
    }

    @Override
    public User createUser(User user) {
        return userService.createUser(user);
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userService.getUserById(id);
    }

    @Override
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @Override
    public User deleteUser(long id) {
        return userService.deleteUser(id);
    }

    @Override
    public Event createEvent(Event event) {
        return eventService.createEvent(event);
    }

    @Override
    public Optional<Event> getEventById(long id) {
        return eventService.getEventById(id);
    }

    @Override
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @Override
    public void deleteEvent(long id) {
        eventService.deleteEvent(id);
    }

    @Override
    public Ticket createTicket(Ticket ticket, Long user_id, Long event_id) {
        return ticketService.createTicket(ticket, user_id, event_id);
    }

    @Override
    public Optional<Ticket> getTicketById(long id) {
        return ticketService.getTicketById(id);
    }

    @Override
    public List<Ticket> getTickets() {
        return ticketService.getTickets();
    }

    @Override
    public void deleteTicket(long id) {
        ticketService.deleteTicket(id);
    }
}
