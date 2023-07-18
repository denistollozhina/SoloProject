package com.denis.jobportal.controllers;

import com.denis.jobportal.models.User;
import com.denis.jobportal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/users") // Base path for all user-related endpoints
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Add methods to handle user-related HTTP requests, such as registration, login, profile view, etc.
    // For example:

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "login.jsp"; // register.html will be the name of the Thymeleaf template for user registration form
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        // Implement your user registration logic using the userService here
        // For example: userService.registerUser(user);
        return "redirect:/users/login"; // Redirect to the login page after successful registration
    }

    // More user-related methods go here
    // ...
}
