package com.example.springbootapp;

import com.example.springbootapp.dao.Event;
import com.example.springbootapp.dao.Ticket;
import com.example.springbootapp.dao.User;
import com.example.springbootapp.repository.EventRepository;
import com.example.springbootapp.repository.TicketRepository;
import com.example.springbootapp.repository.UserRepository;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPATicketTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TicketRepository ticketRepository;

    User user;
    Event event;

    @Before
    public void setUp() {
        user = new User("Nick", "123456", true, "ADMIN", "Nick@gmail.com");
        event = eventRepository.save(new Event("Title", new Date(1)));

        userRepository.save(user);
        eventRepository.save(event);
    }

    @Test
    public void shouldFindNoTicketIfRepositoryIsEmpty() {
        List<Ticket> tickets = ticketRepository.findAll();

        assertThat(tickets.size()).isEqualTo(0);
    }
    @Test
    public void shouldCreateTicket() {
        Ticket ticket = ticketRepository.save(
                new Ticket(event, user, 20, Locale.Category.DISPLAY));

        assertThat(ticket).hasFieldOrPropertyWithValue("event_id", event);
        assertThat(ticket).hasFieldOrPropertyWithValue("user_id", user);
        assertThat(ticket).hasFieldOrPropertyWithValue("place", 20);
    }

    @Test
    public void shouldFindAllTickets() {
        Ticket ticket1 = ticketRepository.save(new Ticket(event, user, 21, Locale.Category.DISPLAY));
        entityManager.persist(ticket1);

        Ticket ticket2 = ticketRepository.save(new Ticket(event, user, 22, Locale.Category.DISPLAY));
        entityManager.persist(ticket2);

        Ticket ticket3 = ticketRepository.save(new Ticket(event, user, 23, Locale.Category.DISPLAY));
        entityManager.persist(ticket3);

        List<Ticket> tickets = ticketRepository.findAll();

        AssertionsForInterfaceTypes.assertThat(tickets).hasSize(3).contains(ticket1, ticket2, ticket3);
    }

    @Test
    public void shouldFindTicketById() {
        Ticket ticket1 = ticketRepository.save(new Ticket(event, user, 21, Locale.Category.DISPLAY));
        entityManager.persist(ticket1);

        Ticket ticket2 = ticketRepository.save(new Ticket(event, user, 22, Locale.Category.DISPLAY));
        entityManager.persist(ticket2);

        Ticket ticket = ticketRepository.findById(ticket2.getId()).orElse(null);

        assertThat(ticket2).isEqualTo(ticket);
    }

    @Test
    public void shouldDeleteTicketById() {
        Ticket ticket1 = ticketRepository.save(new Ticket(event, user, 21, Locale.Category.DISPLAY));
        entityManager.persist(ticket1);

        Ticket ticket2 = ticketRepository.save(new Ticket(event, user, 22, Locale.Category.DISPLAY));
        entityManager.persist(ticket2);

        ticketRepository.deleteById(ticket2.getId());

        List<Ticket> tickets = ticketRepository.findAll();

        AssertionsForInterfaceTypes.assertThat(tickets).hasSize(1).contains(ticket1);
    }

}
