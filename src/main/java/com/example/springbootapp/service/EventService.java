package com.example.springbootapp.service;

import com.example.springbootapp.model.Event;
import com.example.springbootapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void crateEvent(Event event) {
        eventRepository.crateEvent(event);
    }

    public Event getEvent(String title) {
        return eventRepository.getEvent(title);
    }

    public Event getEventById(long id) {
        return eventRepository.getEventById(id);
    }


}
