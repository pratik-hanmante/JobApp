package com.pratik.firstjobapp.Review.impl;

import com.pratik.firstjobapp.Review.Review; // Importing the Review entity
import com.pratik.firstjobapp.Review.ReviewRepository; // Importing the ReviewRepository interface
import com.pratik.firstjobapp.Review.ReviewService; // Importing the ReviewService interface
import org.springframework.stereotype.Service; // Importing the Service annotation

import java.util.List; // Importing the List interface

@Service // Indicates that this class is a service component in the Spring context
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository; // Declaring the ReviewRepository dependency

    // Constructor for dependency injection
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository; // Initializing the ReviewRepository dependency
    }

    /**
     * Retrieves all reviews for a given company ID.
     *
     * @param companyId the ID of the company for which to retrieve reviews
     * @return a list of reviews for the specified company
     */
    @Override
    public List<Review> getAllReviews(Long companyId) {
        // Retrieve the list of reviews for the given company ID
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews; // Return the list of reviews
    }
}