package com.example.springbootapp.controller;

import com.example.springbootapp.dao.Ticket;
import com.example.springbootapp.facade.Booking;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final Booking booking;

    public TicketController(Booking booking) {
        this.booking = booking;
    }

    @PostMapping("/user/{user_id}/event/{event_id}/create")
    public ResponseEntity<Ticket> createTicket(@PathVariable long user_id, @PathVariable long event_id, @RequestBody Ticket ticket) {
        try {
            Ticket ticketTmp = booking.createTicket(ticket, user_id, event_id);
            return new ResponseEntity<>(ticketTmp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Ticket> getTicket(@PathVariable long id) {
        Optional<Ticket> ticketData = booking.getTicketById(id);
        return ticketData.map(ticket -> new ResponseEntity<>(ticket, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Ticket>> getTickets() {
        try {
            List<Ticket> tickets = booking.getTickets();
            if (tickets.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tickets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Ticket> deleteTicketById(@PathVariable long id) {
        try {
            booking.deleteTicket(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
