package com.example.springbootapp.facade;

import com.example.springbootapp.model.Event;
import com.example.springbootapp.model.Ticket;
import com.example.springbootapp.model.User;
import com.example.springbootapp.service.EventService;
import com.example.springbootapp.service.TicketService;
import com.example.springbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookingFacade implements Booking {

    private final EventService eventService;
    private final UserService userService;
    private final TicketService ticketService;

    @Autowired
    public BookingFacade(EventService eventService, UserService userService, TicketService ticketService) {
        this.eventService = eventService;
        this.userService = userService;
        this.ticketService = ticketService;
    }


    @Override
    public Event getEventsByTitle(String title) {
        return eventService.getEvent(title);
    }

    @Override
    public User getUsersByName(String name) {
        return userService.getUser(name);
    }

    public User getUserById(long id) {
        return userService.getUserById(id);
    }

    @Override
    public Event getEventById(long id) {
        return eventService.getEventById(id);
    }

    @Override
    public Ticket getBookedTickets(Long id) {
        return ticketService.getTicket(id);
    }

    @Override
    public void cancelTicket(Ticket ticket) {
        ticketService.cancelTicket(ticket);
    }

    @Override
    public void createTicket(Ticket ticket) {
        ticketService.createTicket(ticket);
    }

    @Override
    public void createUser(User user) {
        userService.createUser(user);
    }

    @Override
    public void createEvent(Event event) {
        eventService.crateEvent(event);
    }
}
