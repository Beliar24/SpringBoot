package com.example.springbootapp.facade;

import com.example.springbootapp.dao.Event;
import com.example.springbootapp.dao.Ticket;
import com.example.springbootapp.dao.User;

import java.util.List;
import java.util.Optional;

public interface Facade {

    public User createUser(User user);

    public Optional<User> getUserById(long id);

    public List<User> getUsers();

    public User deleteUser(long id);

    public Event createEvent(Event event);

    public Optional<Event> getEventById(long id);

    public List<Event> getEvents();

    public void deleteEvent(long id);

    public Ticket createTicket(Ticket ticket, Long event_id, Long user_id);

    public Optional<Ticket> getTicketById(long id);

    public List<Ticket> getTickets();

    public void deleteTicket(long id);
}
