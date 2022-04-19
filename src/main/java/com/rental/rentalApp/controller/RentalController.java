package com.rental.rentalApp.controller;

import com.rental.rentalApp.entities.*;
import com.rental.rentalApp.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    public ResponseEntity<Iterable<Rental>> getAllRentals(
            @RequestParam(required = false) Client client,
            @RequestParam(required = false) Employee employee,
            @RequestParam(required = false) Vehicle vehicle
    ) {
        if (client != null) return ResponseEntity.ok(rentalService.getAllRentalsByClient(client));
        else if (employee != null) return ResponseEntity.ok(rentalService.getAllRentalsByEmployee(employee));
        else if (vehicle != null) return ResponseEntity.ok(rentalService.getAllRentalsByVehicle(vehicle));
        else return ResponseEntity.ok(rentalService.getAllRentals());
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
    public ResponseEntity<String> newRental(@RequestBody Rental rental)
    {
        if (rental == null) return ResponseEntity.badRequest().build();

        rentalService.addRental(rental);
        return ResponseEntity.ok(String.format("Rental %s saved successfully", rental));
    }

    @PutMapping("rental-app/{id}/update-rental")
    public ResponseEntity<String> patchRental(@RequestParam Integer id, @RequestBody Rental updateData) {

        StringBuilder response = new StringBuilder();

        if (!rentalService.getRental(id).isPresent())
            return ResponseEntity.badRequest().build();
        Rental rental = rentalService.getRental(id).get();

        if (updateData.getVehicle() != null) {
            rental.setVehicle(updateData.getVehicle());
            response.append(String.format("Rental vehicle updated: %s\n", updateData.getVehicle()));
        }

        if (updateData.getClient() != null) {
            rental.setClient(updateData.getClient());
            response.append(String.format("Rental client updated: %s\n", updateData.getClient()));
        }

        if (updateData.getEmployee() != null) {
            rental.setEmployee(updateData.getEmployee());
            response.append(String.format("Rental employee updated: %s\n", updateData.getEmployee()));
        }

        if (updateData.getAddress() != null) {
            rental.setAddress(updateData.getAddress());
            response.append(String.format("Rental address updated: %s\n", updateData.getAddress()));
        }

        if (updateData.getBalance() != null) {
            rental.setBalance(updateData.getBalance());
            response.append(String.format("Rental balance updated: %s\n", updateData.getBalance()));
        }

        if (updateData.getPaymentMethod() != null) {
            rental.setAPaymentMethod(updateData.getPaymentMethod());
            response.append(String.format("Rental payment method updated: %s\n", updateData.getPaymentMethod()));
        }

        if (updateData.getStartDate() != null) {
            rental.setStartDate(updateData.getStartDate());
            response.append(String.format("Rental start date updated: %s\n", updateData.getStartDate()));
        }

        if (updateData.getEndDate() != null) {
            rental.setStartDate(updateData.getEndDate());
            response.append(String.format("Rental end date updated: %s\n", updateData.getEndDate()));
        }

        if (updateData.getStatus() != null) {
            rental.setStatus(updateData.getStatus());
            response.append(String.format("Rental status updated: %s\n", updateData.getStatus()));
        }

        if (updateData.getReview() != null) {
            rental.setReview(updateData.getReview());
            response.append(String.format("Rental review updated: %s\n", updateData.getReview()));
        }

//        rentalService.updateRental(id, rental);

        return ResponseEntity.ok(response.toString());
    }

    @GetMapping("rental-app/{id}/get-total-cost")
    public ResponseEntity<BigDecimal> getTotalCost(@PathVariable Integer id)
    {
        if(rentalService.getRental(id).isPresent())
        {
            return  ResponseEntity.ok(rentalService.getTotalCost(id));
        }
        else
            return ResponseEntity.noContent().build();
    }

    @GetMapping("rental-app/{id}/get-rental-cost")
    public ResponseEntity<BigDecimal> getRentalCost(@PathVariable Integer id)
    {
        if(rentalService.getRental(id).isPresent())
        {
            return  ResponseEntity.ok(rentalService.calculateRentalCost(id));
        }
        else
            return ResponseEntity.noContent().build();
    }

    @PutMapping("rental-app/{id}/make-payment")
    public void makePayment(@PathVariable Integer id, @RequestBody Rental rental, @RequestParam BigDecimal payment)
    {
        if(rentalService.getRental(id).isPresent())
        {
            rentalService.makePayment(id, rental, payment);
        }
        else
            return;ResponseEntity.noContent().build();
    }

    @PostMapping("rental-app/{id}/add-rental-review")
    public ResponseEntity<String> addRentalReview(@PathVariable Integer id, @RequestBody Review review) {

        if (review == null)
            return ResponseEntity.badRequest().build();

        if (!rentalService.getRental(id).isPresent())
            return ResponseEntity.badRequest().build();

        Rental rental = rentalService.getRental(id).get();

        if (rental.getReview() != null)
            return ResponseEntity.badRequest().build();

        rental.setReview(review);
        reviewService.addReview(review);

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
