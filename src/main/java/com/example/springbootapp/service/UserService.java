package com.example.springbootapp.service;

import com.example.springbootapp.dao.User;

import com.example.springbootapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepositoryI) {
        this.userRepository = userRepositoryI;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User deleteUser(long id) {
        Optional<User> user = userRepository.findById(id);
        User tmp = user.orElse(null);
        assert tmp != null;
        userRepository.delete(tmp);
        return tmp;
    }
}
