package com.pratik.firstjobapp.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
}
