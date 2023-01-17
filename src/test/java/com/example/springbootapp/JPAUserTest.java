package com.example.springbootapp;

import com.example.springbootapp.dao.User;
import com.example.springbootapp.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPAUserTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void shouldFindNoUserIfRepositoryIsEmpty() {
        List<User> users = userRepository.findAll();

        assertThat(users.size()).isEqualTo(0);
    }
    @Test
    public void shouldCreateUser() {
        User user = userRepository.save(
                new User("Nick", "123456", true, "ADMIN", "Nick@gmail.com"));

        assertThat(user).hasFieldOrPropertyWithValue("username", "Nick");
        assertThat(user).hasFieldOrPropertyWithValue("password", "123456");
        assertThat(user).hasFieldOrPropertyWithValue("is_active", true);
    }

    @Test
    public void shouldFindAllUsers() {
        User user1 = new User("Nick1", "123456", true, "ADMIN", "Nick1@gmail.com");
        entityManager.persist(user1);

        User user2 = new User("Nick2", "123456", true, "ADMIN", "Nick2@gmail.com");
        entityManager.persist(user2);

        User user3 = new User("Nick3", "123456", true, "ADMIN", "Nick3@gmail.com");
        entityManager.persist(user3);

        List<User> users = userRepository.findAll();

        assertThat(users).hasSize(3).contains(user1, user2, user3);
    }

    @Test
    public void shouldFindUserById() {
        User user1 = new User("Nick1", "123456", true, "ADMIN", "Nick1@gmail.com");
        entityManager.persist(user1);

        User user2 = new User("Nick2", "123456", true, "ADMIN", "Nick2@gmail.com");
        entityManager.persist(user2);

        User user = userRepository.findById(user2.getId()).orElse(null);

        assertThat(user).isEqualTo(user2);
    }

    @Test
    public void shouldFindUserByUsername() {
        User user1 = new User("Nick1", "123456", true, "ADMIN", "Nick1@gmail.com");
        entityManager.persist(user1);

        User user2 = new User("Nick2", "123456", true, "ADMIN", "Nick2@gmail.com");
        entityManager.persist(user2);

        User user = userRepository.findUserByUsername(user2.getUsername()).orElse(null);

        assertThat(user).isEqualTo(user2);
    }

    @Test
    public void shouldDeleteUserById() {
        User user1 = new User("Nick1", "123456", true, "ADMIN", "Nick1@gmail.com");
        entityManager.persist(user1);

        User user2 = new User("Nick2", "123456", true, "ADMIN", "Nick2@gmail.com");
        entityManager.persist(user2);

        userRepository.deleteById(user2.getId());

        List<User> users = userRepository.findAll();

        assertThat(users).hasSize(1).contains(user1);
    }

}
