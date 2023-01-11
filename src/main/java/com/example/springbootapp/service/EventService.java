package com.example.springbootapp.service;

import com.example.springbootapp.dao.Event;
import com.example.springbootapp.repository.EventRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event){
        return eventRepository.save(event);
    }

    public Optional<Event> getEventById(long id) {
        return eventRepository.findById(id);
    }

    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    public void deleteEvent(long id) {
        eventRepository.deleteById(id);
    }
}
