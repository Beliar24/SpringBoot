package com.example.springbootapp.service;

import com.example.springbootapp.dao.User;

import com.example.springbootapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepositoryI) {
        this.userRepository = userRepositoryI;
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public User getUserById(long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public List<User> getUsers() {
        return userRepository.findAll().stream().toList();
    }

    public User deleteUser(long id) {
        Optional<User> user = userRepository.findById(id);
        User tmp = user.orElse(null);
        assert tmp != null;
        userRepository.delete(tmp);
        return tmp;
    }
}
