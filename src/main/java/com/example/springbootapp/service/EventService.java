package com.example.springbootapp.service;

import com.example.springbootapp.dao.Event;
import com.example.springbootapp.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void createEvent(Event event){
        eventRepository.save(event);
    }

    public Event getEventById(long id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.orElse(null);
    }

    public List<Event> getEvents() {
        return eventRepository.findAll().stream().toList();
    }

    public Event deleteEvent(long id) {
        Optional<Event> event = eventRepository.findById(id);
        Event tmp = event.orElse(null);
        assert tmp != null;
        eventRepository.delete(tmp);
        return tmp;
    }
}
