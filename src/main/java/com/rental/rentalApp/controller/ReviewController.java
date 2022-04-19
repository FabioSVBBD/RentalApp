package com.rental.rentalApp.controller;

import com.rental.rentalApp.entities.Review;
import com.rental.rentalApp.services.ReviewService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("rental-app/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Review>> getReviews(@RequestParam(required = false) Integer limit) {
        if (limit == null) limit = -1;
        return ResponseEntity.ok(reviewService.getReviews(limit));
    }

    @GetMapping("view-top-reviews")
    public ResponseEntity<Iterable<Review>> getTopReviews(
            @RequestParam(required = false) Integer limit) {
        if (limit == null) limit = -1;
        return ResponseEntity.ok(reviewService.getTopReviews(limit));
    }

    @GetMapping("view-reviews-by-date")
    public ResponseEntity<Iterable<Review>> getReviewsByDate(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateTime) {

        if (startDateTime != null && endDateTime != null)
            return ResponseEntity.ok(reviewService.getReviewsWithin(startDateTime, endDateTime));
        else if (startDateTime != null)
            return ResponseEntity.ok(reviewService.getReviewsAfter(startDateTime));
        else if (endDateTime != null)
            return ResponseEntity.ok(reviewService.getReviewsBefore(endDateTime));
        else
            return ResponseEntity.ok(reviewService.getReviews(-1));

    }



}
