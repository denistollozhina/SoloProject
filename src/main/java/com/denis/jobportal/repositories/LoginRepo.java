package com.denis.jobportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.denis.jobportal.models.LoginUser;

@Repository
public interface LoginRepo extends JpaRepository<LoginUser, Long> {
    // Find a user by email and role, and validate the login by checking the password
    LoginUser findByEmailAndRole(String email, String role);
}
