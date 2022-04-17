package com.rental.rentalApp.controller;

import com.rental.rentalApp.entities.*;
import com.rental.rentalApp.repositories.RentalRepository;
import com.rental.rentalApp.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public void newRental(@RequestBody Rental rental)
    {
        rentalService.addRental(rental);
    }

    @PutMapping("")
    public void updateRental(@RequestParam Integer id,@RequestBody Rental rental)
    {
        rentalService.updateRental(id, rental);
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

    //////

    /*private StatusService statusService;

    public RentalController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("rental-app/update-status/{statusID}/{status}")
    public String updateStatus(@PathVariable Integer statusID, @PathVariable String status){
        return statusService.updateStatus(statusID,status);
    }
    @GetMapping("rental-app/get-status/{status}")
    public List<Status> getStatus(@PathVariable String status){
        return statusService.getStatusByStatus(status);
    } */

}
