package com.example.springbootapp.service;

import com.example.springbootapp.model.User;
import com.example.springbootapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user){
        userRepository.createUser(user);
    }

    public User getUser(String name) {
        return userRepository.getUser(name);
    }

    public User getUserById(long id) {
        return userRepository.getUserById(id);
    }
}
