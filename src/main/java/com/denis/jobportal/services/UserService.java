package com.denis.jobportal.services;

import com.denis.jobportal.models.LoginUser;
import com.denis.jobportal.models.User;
import com.denis.jobportal.repositories.LoginRepo;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UserService {

    private final LoginRepo loginRepo;

    public UserService(LoginRepo loginRepo) {
        this.loginRepo = loginRepo;
    }

    public LoginRepo getLoginRepo() {
        return loginRepo;
    }

    public boolean validateLogin(LoginUser login) {
        // Fetch the user based on the provided email and role
        LoginUser user = loginRepo.findByEmailAndRole(login.getEmail(), "ROLE_USER");

        // Check if the user exists and the password matches
        if (user != null && user.getPassword().equals(login.getPassword())) {
            // Valid login
            return true;
        }

        // Invalid login
        return false;
    }

    public User register(User newUser, BindingResult result) {
        // Your registration logic here, e.g., saving the user to the database
        // ...
        // Return the registered user
        return newUser;
    }

    public LoginUser login(LoginUser newLogin, BindingResult result) {
        // Fetch the user based on the provided email and role
        LoginUser user = loginRepo.findByEmailAndRole(newLogin.getEmail(), "ROLE_USER");

        // Check if the user exists and the password matches
        if (user != null && user.getPassword().equals(newLogin.getPassword())) {
            // Valid login
            return user; // Return the logged-in user
        }

        // Invalid login
        return null; // Return null if login fails
    }
}