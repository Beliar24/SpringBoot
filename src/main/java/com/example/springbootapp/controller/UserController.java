package com.example.springbootapp.controller;

import com.example.springbootapp.dao.UserImpl;
import com.example.springbootapp.facade.BookingFacade;
import com.example.springbootapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final BookingFacade bookingFacade;

    @Autowired
    public UserController(BookingFacade bookingFacade) {
        this.bookingFacade = bookingFacade;
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserImpl user) {
        bookingFacade.createUser(user);
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable long id) {
        return bookingFacade.getUserById(id);
    }
}
