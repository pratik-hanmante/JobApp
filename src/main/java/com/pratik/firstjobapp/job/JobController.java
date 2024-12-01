package com.pratik.firstjobapp.job;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    // Constructor injection
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.findAll();
    }

    @PostMapping
    public String createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return "Job created successfully!";
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if (job == null) {
            throw new RuntimeException("Job not found with ID: " + id);
        }
        return job;
    }

    @DeleteMapping("/{id}")
    public String deleteJobById(@PathVariable Long id) {
        boolean isDeleted = jobService.deleteJobById(id);
        if (isDeleted) {
            return "Job deleted successfully!";
        } else {
            return "Job not found with ID: " + id;
        }
    }

    @PutMapping("/{id}")
    public String updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {
        boolean isUpdated = jobService.updateJob(id, updatedJob);
        if (isUpdated) {
            return "Job updated successfully!";
        } else {
            return "Job not found with ID: " + id;
        }
    }
}
