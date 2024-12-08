package com.pratik.firstjobapp.job;

import com.pratik.firstjobapp.company.Company;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

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
        Company c = job.getCompany();
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
        return isDeleted ? "Job deleted successfully!" : "Job not found with ID: " + id;
    }

    @PutMapping("/{id}")
    public String updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {
        boolean isUpdated = jobService.updateJob(id, updatedJob);
        return isUpdated ? "Job updated successfully!" : "Job not found with ID: " + id;
    }
}
