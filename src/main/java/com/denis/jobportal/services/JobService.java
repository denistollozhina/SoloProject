package com.denis.jobportal.services;

import com.denis.jobportal.models.Job;
import com.denis.jobportal.models.User;
import com.denis.jobportal.repositories.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService { // Rename the service class to 'JobService'
    @Autowired
    private JobRepo jobRepo; // Update the repository type to 'JobRepo'

    public List<Job> allJobs() { // Update the return type to 'List<Job>'
        return jobRepo.findAll(); // Update the method call to use the 'jobRepo'
    }

    public Job updateJob(Job job) { // Update the parameter and return type to 'Job'
        return jobRepo.save(job); // Update the method call to use the 'jobRepo'
    }

    public List<Job> getAssignedJobs(User user) { // Update the parameter and return type to 'List<Job>'
        return jobRepo.findAllByTeamMembers(user); // Update the method call to use the 'jobRepo'
    }

    public JobRepo getJobRepo() {
        return jobRepo;
    }

    public void setJobRepo(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public List<Job> getUnassignedJobs(User user) { // Update the parameter and return type to 'List<Job>'
        return jobRepo.findByTeamMembersNotContains(user); // Update the method call to use the 'jobRepo'
    }

    public Job addJob(Job job) { // Update the parameter and return type to 'Job'
        return jobRepo.save(job); // Update the method call to use the 'jobRepo'
    }

    public void deleteJob(Job job) { // Update the parameter to 'Job'
        jobRepo.delete(job); // Update the method call to use the 'jobRepo'
    }

    public Job findById(Long id) { // Update the return type to 'Job'
        Optional<Job> optionalJob = jobRepo.findById(id); // Update the optional type to 'Job'
        if (optionalJob.isPresent()) {
            return optionalJob.get(); // Update the optional method call to use the 'Job'
        } else {
            return null;
        }
    }
}

