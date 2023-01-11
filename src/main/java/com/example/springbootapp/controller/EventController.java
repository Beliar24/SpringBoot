package com.example.springbootapp.controller;

import com.example.springbootapp.dao.Event;
import com.example.springbootapp.facade.Booking;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    private final Booking booking;

    public EventController(Booking booking) {
        this.booking = booking;
    }

    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        try {
            Event eventTmp = booking.createEvent(event);
            return new ResponseEntity<>(eventTmp, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable long id) {
        Optional<Event> eventData = booking.getEventById(id);
        return eventData.map(event -> new ResponseEntity<>(event, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Event>> getEvents() {
        try {
            List<Event> events = booking.getEvents();
            if (events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Event> deleteEventById(@PathVariable long id) {
        try {
            booking.deleteEvent(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
