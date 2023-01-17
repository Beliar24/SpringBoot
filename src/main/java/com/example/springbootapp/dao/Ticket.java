package com.example.springbootapp.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Locale;

@Entity
@Table(name = "tickets")
@Setter
@Getter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "event_id")
    private Event event_id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user_id;

    @Column(name = "place")
    private int place;
    @Column(name = "category")
    private Locale.Category category;

    public Ticket(Event event_id, User user_id, int place, Locale.Category category) {
        this.event_id = event_id;
        this.user_id = user_id;
        this.place = place;
        this.category = category;
    }

    public Ticket() {
    }
}