package com.example.springbootapp.repository;

import com.example.springbootapp.dao.EventImpl;
import com.example.springbootapp.model.Event;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class EventRepository {

    private final EntityManager entityManager;

    @Autowired
    public EventRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void crateEvent(Event event) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(event);
    }

    public Event getEvent(String title) {
        return entityManager.find(EventImpl.class, title);
    }

    public Event getEventById(long id) {
        return entityManager.find(EventImpl.class, id);
    }
}
