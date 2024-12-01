package com.pratik.firstjobapp.job;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JobRepository {

    private final List<Job> jobList = new ArrayList<>();

    public List<Job> findAll() {
        return new ArrayList<>(jobList); // Return a copy of the list
    }

    public void save(Job job) {
        jobList.add(job);
    }

    public Optional<Job> findById(Long id) {
        return jobList.stream()
                .filter(job -> job.getId().equals(id))
                .findFirst();
    }

    public void deleteById(Long id) {
        jobList.removeIf(job -> job.getId().equals(id));
    }
}
