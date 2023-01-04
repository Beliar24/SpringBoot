package com.example.springbootapp.controller;

import com.example.springbootapp.dao.TicketImpl;
import com.example.springbootapp.facade.BookingFacade;
import com.example.springbootapp.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final BookingFacade bookingFacade;

    @Autowired
    public TicketController(BookingFacade bookingFacade) {
        this.bookingFacade = bookingFacade;
    }

    @PostMapping("/create")
    public void createTicket(@RequestBody TicketImpl ticket) {
        bookingFacade.createTicket(ticket);
    }

    @GetMapping("/get/{id}")
    public Ticket getTicket(@PathVariable long id) {
        return bookingFacade.getBookedTickets(id);
    }

    @DeleteMapping("/cancel/{id}")
    public void deleteTicket(@PathVariable long id) {
        Ticket ticket = bookingFacade.getBookedTickets(id);
        bookingFacade.cancelTicket(ticket);
    }
}
