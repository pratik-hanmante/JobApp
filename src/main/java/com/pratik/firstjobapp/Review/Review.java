package com.pratik.firstjobapp.Review;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pratik.firstjobapp.company.Company;
import jakarta.persistence.*;

@Entity
public class Review {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String title;

    public Long getId() {
        return id;
    }

    @JsonIgnore
    @ManyToMany
    private Company company;

    public Review() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    private String description;
        private double rating;
}
