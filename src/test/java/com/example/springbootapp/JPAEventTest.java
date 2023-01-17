package com.example.springbootapp;

import com.example.springbootapp.dao.Event;
import com.example.springbootapp.repository.EventRepository;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPAEventTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EventRepository eventRepository;


    @Test
    public void shouldFindNoEventIfRepositoryIsEmpty() {
        List<Event> events = eventRepository.findAll();

        assertThat(events.size()).isEqualTo(0);
    }
    @Test
    public void shouldCreateEvent() {
        Event event = eventRepository.save(
                new Event("Title", new Date(1)));

        assertThat(event).hasFieldOrPropertyWithValue("title", "Title");
    }

    @Test
    public void shouldFindAllEvents() {
        Event event1 = eventRepository.save(new Event("Title1", new Date(1)));

        Event event2 = eventRepository.save(new Event("Title2", new Date(1)));

        Event event3 = eventRepository.save(new Event("Title3", new Date(1)));

        List<Event> users = eventRepository.findAll();

        AssertionsForInterfaceTypes.assertThat(users).hasSize(3).contains(event1, event2, event3);
    }

    @Test
    public void shouldFindEventsById() {
        Event event1 = eventRepository.save(new Event("Title1", new Date(1)));
        entityManager.persist(event1);

        Event event2 = eventRepository.save(new Event("Title1", new Date(1)));
        entityManager.persist(event2);

        Event event = eventRepository.findById(event2.getId()).orElse(null);

        assertThat(event).isEqualTo(event2);
    }

    @Test
    public void shouldDeleteEventById() {
        Event event1 = eventRepository.save(new Event("Title1", new Date(1)));
        entityManager.persist(event1);

        Event event2 = eventRepository.save(new Event("Title1", new Date(1)));
        entityManager.persist(event2);

        eventRepository.deleteById(event2.getId());

        List<Event> events = eventRepository.findAll();

        AssertionsForInterfaceTypes.assertThat(events).hasSize(1).contains(event1);
    }
}
