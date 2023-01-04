package com.example.springbootapp.repository;

import com.example.springbootapp.dao.UserImpl;
import com.example.springbootapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserRepository {

    private final EntityManager entityManager;

    @Autowired
    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void createUser(User user) {
        entityManager.merge(user);
    }

    public User getUser(String username) {
        return entityManager.find(UserImpl.class, username);
    }

    public User getUserById(long id) {
        return entityManager.find(UserImpl.class, id);
    }
}
