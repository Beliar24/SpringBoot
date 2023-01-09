package com.example.springbootapp.facade;

import com.example.springbootapp.dao.Event;
import com.example.springbootapp.dao.Ticket;
import com.example.springbootapp.dao.User;
import com.example.springbootapp.service.EventService;
import com.example.springbootapp.service.TicketService;
import com.example.springbootapp.service.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
    public void createUser(User user) {
        userService.createUser(user);
    }

    @Override
    public User getUserById(long id) {
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
    public void createEvent(Event event) {
        eventService.createEvent(event);
    }

    @Override
    public Event getEventById(long id) {
        return eventService.getEventById(id);
    }

    @Override
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @Override
    public Event deleteEvent(long id) {
        return eventService.deleteEvent(id);
    }

    @Override
    public void createTicket(Ticket ticket) {
        ticketService.createTicket(ticket);
    }

    @Override
    public Ticket getTicketById(long id) {
        return ticketService.getTicketById(id);
    }

    @Override
    public List<Ticket> getTickets() {
        return ticketService.getTickets();
    }

    @Override
    public Ticket deleteTicket(long id) {
        return ticketService.deleteTicket(id);
    }
}
