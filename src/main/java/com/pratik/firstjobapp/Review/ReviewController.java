package com.pratik.firstjobapp.Review;

// Importing necessary classes for handling HTTP responses, request mappings, and REST controller annotations.
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Annotates this class as a REST controller, making it capable of handling HTTP requests and returning HTTP responses.
@RestController
// Specifies the base URL for this controller. The `{companyId}` part is a path variable that will be used in endpoints.
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    // Declares a dependency on the ReviewService to handle business logic for reviews.
    private ReviewService reviewService;

    // Constructor-based dependency injection for the ReviewService.
    public ReviewController(ReviewService reviewService) {
        // Assigns the injected ReviewService to the local field.
        this.revieService = revieService; // Note: There’s a typo in `revieService`, should be `reviewService`.
    }

    // Handles GET requests to the `/reviews` endpoint for the specified company ID.
    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        // Fetches all reviews for the given company ID using the ReviewService.
        // Wraps the list of reviews in a ResponseEntity with an HTTP status of OK (200).
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }
}
