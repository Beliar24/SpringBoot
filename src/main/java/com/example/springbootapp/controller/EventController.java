package com.example.springbootapp.controller;

import com.example.springbootapp.dao.Event;
import com.example.springbootapp.facade.Booking;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final Booking booking;

    public EventController(Booking booking) {
        this.booking = booking;
    }

    @PostMapping("/create")
    public void createEvent(@RequestBody Event event) {
        booking.createEvent(event);
    }

    @GetMapping("/get/{id}")
    public Event getEvent(@PathVariable long id) {
        return booking.getEventById(id);
    }

    @GetMapping("/get")
    public List<Event> getEvents() {
        return booking.getEvents();
    }

    @DeleteMapping("/delete/{id}")
    public Event deleteEventById(@PathVariable long id) {
        return booking.deleteEvent(id);
    }
}
