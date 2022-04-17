package com.rental.rentalApp.services;

import com.rental.rentalApp.entities.Review;
import com.rental.rentalApp.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviews) {
        this.reviewRepository = reviews;
    }

    public void addReview(Review review) { reviewRepository.save(review); }

    public List<Review> getTopReviews(int limit) {
        List<Review> reviews = reviewRepository.findAll();
        if (limit == -1) limit = reviews.size();
        return reviews.stream().sorted(Comparator.comparing(Review::getRating)).limit(limit).toList();
    }

    public List<Review> getReviewsWithin(LocalDateTime startDate, LocalDateTime endDate) {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().filter(review -> review.getDate().isAfter(startDate) && review.getDate().isBefore(endDate)).toList();
    }

    public List<Review> getReviewsBefore(LocalDateTime dateTime) {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().filter(review -> review.getDate().isBefore(dateTime)).toList();
    }

    public List<Review> getReviewsAfter(LocalDateTime dateTime) {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().filter(review -> review.getDate().isAfter(dateTime)).toList();
    }

}
