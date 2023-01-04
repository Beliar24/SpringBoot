package com.example.springbootapp.dao;

import com.example.springbootapp.model.Ticket;
import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class TicketImpl implements Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "event_id", nullable = false)
    @OneToOne
    private EventImpl eventId;

    @JoinColumn(name = "user_id", nullable = false)
    @OneToOne
    private UserImpl userId;

    @Column(name = "place")
    private int place;
    @Column(name = "category")
    private Category category;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getEventId() {
        return eventId.getId();
    }

    @Override
    public void setEventId(long eventId) {
        this.eventId.setId(eventId);
    }

    @Override
    public long getUserId() {
        return userId.getId();
    }

    @Override
    public void setUserId(long userId) {
        this.userId.setId(userId);
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int getPlace() {
        return place;
    }

    @Override
    public void setPlace(int place) {
        this.place = place;
    }
}
