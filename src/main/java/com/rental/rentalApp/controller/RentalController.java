package com.rental.rentalApp.controller;

import com.rental.rentalApp.entities.*;
import com.rental.rentalApp.repositories.RentalRepository;
import com.rental.rentalApp.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class RentalController {

    //private RentalRepository rentals;

    @Autowired
    private RentalService rentalService;
    final private ReviewService reviewService;

    private RentalController(RentalService rentalService, ReviewService reviewService)
    {
        //this.rentals = rentals;
        this.rentalService = rentalService;
        this.reviewService = reviewService;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Rental>> getAllRentals()
    {
        return ResponseEntity.ok(rentalService.getAllRentals());
    }

    @GetMapping("{id}")
    public ResponseEntity<Rental> getRental(@PathVariable Integer id)
    {
        Optional<Rental> optionalRental = rentalService.getRental(id);

        System.out.println(optionalRental);

        if(optionalRental.isPresent())
        {
            return ResponseEntity.ok(optionalRental.get());
        }
        else return ResponseEntity.noContent().build();
    }

    @PostMapping("rental-app/add-rental")
    public void newRental(@RequestBody Rental rental)
    {
        rentalService.addRental(rental);
    }

    @PutMapping("rental-app/{id}/update-rental")
    public void updateRental(@RequestParam Integer id,@RequestBody Rental rental)
    {
        rentalService.updateRental(id, rental);
    }

    @GetMapping("rental-app/{id}/get-total-cost")
    public ResponseEntity<BigDecimal> getTotalCost(@PathVariable Integer id)
    {
        if(rentalService.getRental(id).isPresent())
        {
            return  ResponseEntity.ok(rentalService.getTotalCost(id));
        }
        else
            return ResponseEntity.badRequest().build();
    }

    @PutMapping("rental-app/{id}/make-payment")
    public void makePayment(@PathVariable Integer id, @RequestBody Rental rental, @RequestParam BigDecimal payment)
    {
        if(rentalService.getRental(id).isPresent())
        {
            rentalService.makePayment(id, rental, payment);
        }
        else
            return;ResponseEntity.badRequest().build();
    }

    @PostMapping("rental-app/{id}/add-review")
    public ResponseEntity<String> postReview(@PathVariable Integer id, @RequestBody Review review) {

        if (review == null)
            return ResponseEntity.badRequest().build();

        if (!rentalService.getRental(id).isPresent())
            return ResponseEntity.badRequest().build();

        Rental rental = rentalService.getRental(id).get();

        if (rental.getReview() != null)
            return ResponseEntity.badRequest().build();

        rental.setReview(review);

        reviewService.addReview(review);
        rentalService.updateRental(id, rental);

        return ResponseEntity.ok(String.format("Review: %s for rental: %s saved successfully", review, rental));
    }

}
