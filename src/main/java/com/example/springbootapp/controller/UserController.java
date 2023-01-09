package com.example.springbootapp.controller;

import com.example.springbootapp.dao.User;
import com.example.springbootapp.facade.Booking;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Booking booking;

    public UserController(Booking booking) {
        this.booking = booking;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        booking.createUser(user);
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable long id) {
        return booking.getUserById(id);
    }

    @GetMapping("/get")
    public List<User> getUsers() {
        return booking.getUsers();
    }

    @DeleteMapping("/delete/{id}")
    public User deleteUserById(@PathVariable long id) {
        return booking.deleteUser(id);
    }
}
