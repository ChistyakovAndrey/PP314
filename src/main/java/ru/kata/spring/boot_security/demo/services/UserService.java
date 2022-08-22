package ru.kata.spring.boot_security.demo.services;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    void saveUser(User user, boolean isAdmin);
    void deleteUser(Integer id);
    void updateUser(User user, String isAdmin);
    void updateUser(User user);
    User findByName(String name);
    User findByEmail(String mail);
    //@EntityGraph(value = "User.graph", type = EntityGraph.EntityGraphType.LOAD)
    List<User> getAllUsers();
    User findByID(Integer id);
}
