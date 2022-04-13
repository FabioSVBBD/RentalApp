package com.rental.rentalApp.repositories;

import com.rental.rentalApp.entities.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findByMessage(String message);
}