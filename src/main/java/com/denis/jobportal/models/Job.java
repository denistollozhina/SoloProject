package com.denis.jobportal.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "jobs") // Rename the table to 'jobs'
public class Job { // Rename the class to 'Job'

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Job Title is required!") // Rename the field to 'Job Title'
    private String jobTitle; // Rename the field to 'Job Title'

    @NotEmpty(message = "Description is required!")
    @Size(min = 3, message = "Description must be at least 3 characters long")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Due Date is required!")
    @Future
    private Date dueDate;

    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    // Modify the relationship to represent the lead of the job
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lead_id") // Update the column name to 'lead_id'
    private User lead; // Keep the name as 'lead'

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getLead() {
        return lead;
    }

    public void setLead(User lead) {
        this.lead = lead;
    }

    public List<User> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<User> teamMembers) {
        this.teamMembers = teamMembers;
    }

    // Modify the relationship to represent the team members of the job
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_jobs", // Rename the table to 'users_jobs'
            joinColumns = @JoinColumn(name = "job_id"), // Update the column name to 'job_id'
            inverseJoinColumns = @JoinColumn(name = "user_id") // Update the column name to 'user_id'
    )
    private List<User> teamMembers; // Rename the field to 'teamMembers'

    // Add any additional fields or relationships specific to the Jobs entity

    public Job(Long id, String jobTitle, String description, @NotNull(message = "Due Date is required!") Date dueDate, Date createdAt, Date updatedAt, User lead, List<User> teamMembers) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.description = description;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lead = lead;
        this.teamMembers = teamMembers;
    }

    public Job() {
    }

    // Generate getters and setters for the new field and relationships
    // (getLead, setLead, getTeamMembers, setTeamMembers)
}
