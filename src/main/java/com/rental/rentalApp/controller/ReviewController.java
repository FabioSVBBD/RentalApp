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
import java.util.Optional;

@RestController
@RequestMapping("rental-app/api/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @GetMapping("top")
    public ResponseEntity<Iterable<Review>> getTopReviews(
            @RequestParam(required = false) Integer limit) {
        List<Review> reviews = reviewRepository.findAll();
        return Optional.of(reviews).<ResponseEntity<Iterable<Review>>>map(reviewList -> ResponseEntity.ok(reviewList.stream().sorted(Comparator.comparing(Review::getRating).reversed()).limit(limit == null ? reviews.size() : limit).toList())).orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Review>> getReviews(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDateTime,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDateTime) {

        List<Review> reviews = reviewRepository.findAll();

        if (startDateTime != null && endDateTime != null)
            return Optional.of(reviews).<ResponseEntity<Iterable<Review>>>map(reviewList -> ResponseEntity.ok(reviewList.stream().filter(review -> review.getDate().isAfter(startDateTime) && review.getDate().isBefore(endDateTime)).toList())).orElseGet(() -> ResponseEntity.badRequest().build());
        else if (startDateTime != null)
            return Optional.of(reviews).<ResponseEntity<Iterable<Review>>>map(reviewList -> ResponseEntity.ok(reviewList.stream().filter(review -> review.getDate().isAfter(startDateTime)).toList())).orElseGet(() -> ResponseEntity.badRequest().build());
        else if (endDateTime != null)
            return Optional.of(reviews).<ResponseEntity<Iterable<Review>>>map(reviewList -> ResponseEntity.ok(reviewList.stream().filter(review -> review.getDate().isBefore(endDateTime)).toList())).orElseGet(() -> ResponseEntity.badRequest().build());
        else
            return Optional.of(reviews).<ResponseEntity<Iterable<Review>>>map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().build());

    }

}
