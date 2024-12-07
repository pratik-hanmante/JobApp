package com.pratik.firstjobapp.company;

import com.pratik.firstjobapp.job.Job;
import jakarta.persistence.*;

import java.util.List;

/**
 * Entity class representing a company in the application.
 * Each company can have multiple jobs associated with it.
 */
@Entity
public class Company {

    /**
     * Primary key for the company entity.
     * The ID is auto-generated using the IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the company.
     */
    private String name;

    /**
     * Description of the company.
     */
    private String description;

    /**
     * List of jobs associated with the company.
     * This defines a one-to-many relationship between Company and Job.
     * Each company can have multiple jobs.
     */
    @OneToMany
    private List<Job> jobs;

    /**
     * Default constructor for the Company entity.
     * This is required by JPA.
     */
    public Company() {
    }

    // Getter and setter methods for the fields.
    // These are used to access and modify the private fields.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    // Uncomment and define the 'reviews' field if reviews are to be associated with a company.
    // This might also require another entity class to manage reviews.
    // private List<Review> reviews;
}
