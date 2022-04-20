package com.rental.rentalApp.controller;

import com.rental.rentalApp.entities.*;
import com.rental.rentalApp.services.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("rental-app/api/rentals")
public class RentalController {

    //private RentalRepository rentals;

    @Autowired
    private RentalService rentalService;
    private RentalController(RentalService rentalService)
    {
        //this.rentals = rentals;
        this.rentalService = rentalService;
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

    @PostMapping("add-rental")
    public ResponseEntity<String> newRental(@RequestBody Rental rental)
    {
        if (rental == null) return ResponseEntity.badRequest().build();

        rentalService.addRental(rental);
        return ResponseEntity.ok(String.format("Rental %s saved successfully", rental));
    }

    @PatchMapping("{id}/update-rental")
    public ResponseEntity<String> patchRental(@PathVariable Integer id, @RequestBody Rental updateData) {

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
            rental.setPaymentMethod(updateData.getPaymentMethod());
            response.append(String.format("Rental payment method updated: %s\n", updateData.getPaymentMethod()));
        }

        if (updateData.getStartDate() != null) {
            rental.setStartDate(updateData.getStartDate());
            response.append(String.format("Rental start date updated: %s\n", updateData.getStartDate()));
        }

        if (updateData.getEndDate() != null) {
            rental.setEndDate(updateData.getEndDate());
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

        rentalService.updateRental(rental);

        return ResponseEntity.ok(response.toString());
    }

    @GetMapping("{id}/get-total-cost")
    public ResponseEntity<BigDecimal> getTotalCost(@PathVariable Integer id)
    {
        if(rentalService.getRental(id).isPresent())
        {
            return  ResponseEntity.ok(rentalService.getTotalCost(id));
        }
        else
            return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/get-rental-cost")
    public ResponseEntity<BigDecimal> getRentalCost(@PathVariable Integer id)
    {
        if(rentalService.getRental(id).isPresent())
        {
            return  ResponseEntity.ok(rentalService.getRentalCost(id));
        }
        else
            return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/make-payment")
    public void makePayment(@PathVariable Integer id, @RequestParam BigDecimal payment)
    {
        if(rentalService.getRental(id).isPresent())
        {
            rentalService.makePayment(id, payment);
        }
        else
            return;ResponseEntity.noContent().build();
    }

    @PostMapping("{id}/add-rental-review")
    public ResponseEntity<String> addRentalReview(@PathVariable Integer id, @RequestBody Review review) {

        if (review == null)
            return ResponseEntity.badRequest().build();

        if (!rentalService.getRental(id).isPresent())
            return ResponseEntity.badRequest().build();

        Rental rental = rentalService.getRental(id).get();
//
//        if (rental.getReview() != null)
//            return ResponseEntity.badRequest().build();

        rental.setReview(review);
        rentalService.updateRental(rental);

        return ResponseEntity.ok(String.format("Review: %s for rental: %s saved successfully", review, rental));
    }

}
