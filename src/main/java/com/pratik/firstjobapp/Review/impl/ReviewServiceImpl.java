package com.pratik.firstjobapp.Review.impl;

import com.pratik.firstjobapp.Review.Review;
import com.pratik.firstjobapp.Review.ReviewRepository;
import com.pratik.firstjobapp.Review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;


    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return List.of();
    }
}
