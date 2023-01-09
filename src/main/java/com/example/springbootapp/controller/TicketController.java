package com.example.springbootapp.controller;

import com.example.springbootapp.dao.Event;
import com.example.springbootapp.dao.Ticket;
import com.example.springbootapp.dao.User;
import com.example.springbootapp.facade.Booking;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final Booking booking;

    public TicketController(Booking booking) {
        this.booking = booking;
    }

    @PostMapping("/user/{user_id}/event/{event_id}/create")
    public void createTicket(@PathVariable long user_id, @PathVariable long event_id, @RequestBody Ticket ticket) {
        Event event = booking.getEventById(event_id);
        User user = booking.getUserById(user_id);
        ticket.setEvent_id(event);
        ticket.setUser_id(user);
        booking.createTicket(ticket);
    }

    @GetMapping("/get/{id}")
    public Ticket getTicket(@PathVariable long id) {
        return booking.getTicketById(id);
    }

    @GetMapping("/get")
    public List<Ticket> getTickets() {
        return booking.getTickets();
    }

    @DeleteMapping("/delete/{id}")
    public Ticket deleteTicketById(@PathVariable long id) {
        return booking.deleteTicket(id);
    }
}
