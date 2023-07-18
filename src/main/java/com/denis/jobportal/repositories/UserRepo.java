package com.denis.jobportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.denis.jobportal.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    // Add any custom queries or methods for user retrieval or manipulation if needed
}
