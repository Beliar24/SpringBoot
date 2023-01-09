package com.example.springbootapp.facade;

import com.example.springbootapp.dao.Event;
import com.example.springbootapp.dao.Ticket;
import com.example.springbootapp.dao.User;

import java.util.List;

public interface Facade {

    public void createUser(User user);

    public User getUserById(long id);

    public List<User> getUsers();

    public User deleteUser(long id);

    public void createEvent(Event event);

    public Event getEventById(long id);

    public List<Event> getEvents();

    public Event deleteEvent(long id);

    public void createTicket(Ticket ticket);

    public Ticket getTicketById(long id);

    public List<Ticket> getTickets();

    public Ticket deleteTicket(long id);
}
