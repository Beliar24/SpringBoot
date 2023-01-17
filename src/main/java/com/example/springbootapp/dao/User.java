package com.example.springbootapp.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "is_active")
    private boolean is_active;

    @Column(name = "roles")
    private String roles;

    @Column(name = "email")
    private String email;

    public User(String username, String password, boolean is_active, String roles, String email) {
        this.username = username;
        this.password = password;
        this.is_active = is_active;
        this.roles = roles;
        this.email = email;
    }

    public User() {
    }
}
