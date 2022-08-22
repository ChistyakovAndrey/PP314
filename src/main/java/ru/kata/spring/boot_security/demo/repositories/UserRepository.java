package ru.kata.spring.boot_security.demo.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @EntityGraph(value = "User_graph")
    User findByName(String username);
    User findByEmail(String mail);

    List<User> findAll();
}
