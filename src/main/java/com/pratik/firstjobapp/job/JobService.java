package com.pratik.firstjobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll(); // Fetch all jobs

    void createJob(Job job); // Add a new job

    Job getJobById(Long id); // Fetch a job by its ID

    boolean deleteJobById(Long id); // Delete a job by its ID

    boolean updateJob(Long id, Job updatedJob); // Update a job by its ID
}



