package ru.kata.spring.boot_security.demo.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppRestController {
    private final UserService userService;

    @Autowired
    public AppRestController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.findByID(id);
    }
    @PostMapping("/users")
    public List<User> addUser(@RequestBody User user){
        userService.saveUser(user, user.getRole().equals("ADMIN"));
        return getAllUsers();
    }
    @PostMapping("/users/{id}")
    public List<User> updateUser(@PathVariable Integer id, @RequestBody User user){
        String admin = (user.toString().contains("ADMIN")) ? "ADMIN" : "USER";
        userService.updateUser(user, admin);
        return getAllUsers();
    }
    @DeleteMapping("/users/{id}")
    public List<User> deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return getAllUsers();
    }
}
