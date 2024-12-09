package com.pratik.firstjobapp.Review;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    public ReviewController(RevieService revieService) {
        this.revieService = revieService;
    }

    private ReviewService reviewService;



}
