package com.example.springbootapp.facade;

import com.example.springbootapp.model.User;
import com.example.springbootapp.model.Event;
import com.example.springbootapp.model.Ticket;
import com.example.springbootapp.model.User;

public interface Booking {
    
    Event getEventsByTitle(String title);
    
    void createEvent(Event event);
    
    User getUsersByName(String name);
    
    void createUser(User user);
    
    void createTicket(Ticket ticket);
    
    Ticket getBookedTickets(Long id);

    void cancelTicket(Ticket ticket);

    User getUserById(long id);

    Event getEventById(long id);
}
