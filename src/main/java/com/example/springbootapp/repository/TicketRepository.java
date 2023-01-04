package com.example.springbootapp.repository;

import com.example.springbootapp.dao.TicketImpl;
import com.example.springbootapp.model.Ticket;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

@Repository
public class TicketRepository {

    private final EntityManager entityManager;

    @Autowired
    public TicketRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createTicket(Ticket ticket) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(ticket);
    }

    public Ticket getTicket(Long id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(TicketImpl.class, id);
    }

    public void cancelTicket(Ticket ticket) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(ticket);
    }
}
