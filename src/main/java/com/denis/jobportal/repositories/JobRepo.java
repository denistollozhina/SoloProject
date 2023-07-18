package com.denis.jobportal.repositories;

import java.util.List;

import com.denis.jobportal.models.Job;
import com.denis.jobportal.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends CrudRepository<Job, Long> {
    List<Job> findAll(); // Update the return type to 'List<Job>'
    Job findByIdIs(Long id); // Update the return type to 'Job'

    // Update the method names to match the new entity and relationship names
    List<Job> findAllByTeamMembers(User user); // Update the parameter and return type to 'List<Job>'
    List<Job> findByTeamMembersNotContains(User user); // Update the parameter and return type to 'List<Job>'
}
