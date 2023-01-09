package com.example.springbootapp.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "events")
@Setter
@Getter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private Date date;
}