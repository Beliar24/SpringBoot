package com.example.springbootapp.controller;

import com.example.springbootapp.dao.EventImpl;
import com.example.springbootapp.facade.BookingFacade;
import com.example.springbootapp.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    private final BookingFacade bookingFacade;

    @Autowired
    public EventController(BookingFacade bookingFacade) {
        this.bookingFacade = bookingFacade;
    }

    @PostMapping("/create")
    public void createEvent(@RequestBody EventImpl event) {
        bookingFacade.createEvent(event);
    }

    @GetMapping("/get/{id}")
    public Event getEvent(@PathVariable long id) {
        return bookingFacade.getEventById(id);
    }
}
