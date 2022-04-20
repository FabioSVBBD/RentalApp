package com.rental.rentalApp.controller;

import com.rental.rentalApp.entities.Review;
import com.rental.rentalApp.repositories.ReviewRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("rental-app/api/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Review>> getReviews(@RequestParam(required = false) Integer limit) {
        List<Review> reviews = reviewRepository.findAll();
        return ResponseEntity.ok(reviews.stream().limit(limit == -1 ? reviews.size() : limit).toList());
    }

    @GetMapping("top")
    public ResponseEntity<Iterable<Review>> getTopReviews(
            @RequestParam(required = false) Integer limit) {
        List<Review> reviews = reviewRepository.findAll();
        return ResponseEntity.ok(reviews.stream().sorted(Comparator.comparing(Review::getRating).reversed()).limit((limit == -1 ? reviews.size() : limit)).toList());
    }

    @GetMapping("view-reviews-by-date")
    public ResponseEntity<Iterable<Review>> getReviewsByDate(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateTime) {

        List<Review> reviews = reviewRepository.findAll();

        if (startDateTime != null && endDateTime != null)
            return ResponseEntity.ok(reviews.stream().filter(review -> review.getDate().isAfter(startDateTime) && review.getDate().isBefore(endDateTime)).toList());
        else if (startDateTime != null)
            return ResponseEntity.ok(reviews.stream().filter(review -> review.getDate().isAfter(startDateTime)).toList());
        else if (endDateTime != null)
            return ResponseEntity.ok(reviews.stream().filter(review -> review.getDate().isAfter(endDateTime)).toList());
        else
            return ResponseEntity.ok(reviews);

    }



}
