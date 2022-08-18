package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.UserService;
import ru.kata.spring.boot_security.demo.services.impl.UserServiceImpl;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/all_users")
    public String getAdminPage(Model model, Model model2, Principal principal) {
        model2.addAttribute("currentUser", userService.findByName(principal.getName()));
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "/admin/all_users";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user, @RequestParam(value = "role")
    String admin) {
        boolean isAdmin = admin.equals("ADMIN");
        userService.saveUser(user, isAdmin);
        return "redirect:/admin/all_users";
    }

    @GetMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam(value = "roles1")
    String admin) {
        userService.updateUser(user, admin);
        return "redirect:/admin/all_users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/admin/all_users";
    }
}
