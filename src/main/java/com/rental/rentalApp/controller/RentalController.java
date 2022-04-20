package com.rental.rentalApp.controller;

import com.rental.rentalApp.entities.*;
import com.rental.rentalApp.repositories.RentalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("rental-app/api/rentals")
public class RentalController {

    @Autowired
    private RentalRepository rentalRepository;

    private RentalController(RentalRepository rentalRepository)
    {
        this.rentalRepository = rentalRepository;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Rental>> getAllRentals(
            @RequestParam(required = false) Client client,
            @RequestParam(required = false) Employee employee,
            @RequestParam(required = false) Vehicle vehicle
    ) {
        if (client != null) return ResponseEntity.ok(rentalRepository.findByClient(client));
        if (employee != null) return ResponseEntity.ok(rentalRepository.findByEmployee(employee));
        if (vehicle != null) return ResponseEntity.ok(rentalRepository.findByVehicle(vehicle));
        else return ResponseEntity.ok(rentalRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Rental> getRental(@PathVariable Integer id)
    {
        Optional<Rental> optionalRental = rentalRepository.findById(id);

        if(optionalRental.isPresent())
        {
            return ResponseEntity.ok(optionalRental.get());
        }
        else return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<String> newRental(@RequestBody Rental rental)
    {
        if (rental == null) return ResponseEntity.badRequest().build();
        rentalRepository.save(rental);
        return ResponseEntity.ok(String.format("Rental %s saved successfully", rental));
    }

    @PatchMapping("{id}")
    public ResponseEntity<String> patchRental(@PathVariable Integer id, @RequestBody Rental updateData) {

        StringBuilder response = new StringBuilder();

        if (!rentalRepository.findById(id).isPresent())
            return ResponseEntity.badRequest().build();
        Rental rental = rentalRepository.findById(id).get();

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

        rentalRepository.save(rental);

        return ResponseEntity.ok(response.toString());
    }

    @GetMapping("{id}/total-cost")
    public ResponseEntity<BigDecimal> getTotalCost(@PathVariable Integer id)
    {
        if(rentalRepository.findById(id).isPresent())
        {
            return  ResponseEntity.ok(rentalRepository.findById(id).get().getTotalCost());
        }
        else
            return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/rental-cost")
    public ResponseEntity<BigDecimal> getRentalCost(@PathVariable Integer id)
    {
        if(rentalRepository.findById(id).isPresent())
        {
            return  ResponseEntity.ok(rentalRepository.findById(id).get().getRentalCost());
        }
        else
            return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}/pay")
    public void makePayment(@PathVariable Integer id, @RequestParam BigDecimal payment)
    {
        if(rentalRepository.findById(id).isPresent())
        {
            rentalRepository.findById(id).get().makePayment(payment);
        }
        else
            return;ResponseEntity.noContent().build();
    }

    @PostMapping("{id}/review")
    public ResponseEntity<String> addRentalReview(@PathVariable Integer id, @RequestBody Review review) {

        if (review == null)
            return ResponseEntity.badRequest().build();

        if (!rentalRepository.findById(id).isPresent())
            return ResponseEntity.badRequest().build();

        Rental rental = rentalRepository.findById(id).get();
        rental.setReview(review);
        rentalRepository.save(rental);

        return ResponseEntity.ok(String.format("Review: %s for rental: %s saved successfully", review, rental));
    }

}
