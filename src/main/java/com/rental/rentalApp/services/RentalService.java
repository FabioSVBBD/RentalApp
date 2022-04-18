package com.rental.rentalApp.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.rental.rentalApp.entities.*;
import com.rental.rentalApp.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    public List<Rental> getAllRentals()
    {
        List<Rental> rentals = new ArrayList<>();
        rentalRepository.findAll()
                .forEach(rentals::add);
        return rentals;
    }

    public Optional<Rental> getRental(Integer id)
    {
        return rentalRepository.findById(id);
    }

    public void addRental(Rental rental)
    {
        rentalRepository.save(rental);
    }

    public void updateRental(Integer id, Rental rental)
    {
        rentalRepository.save(rental);
    }

    public void deleteRental(Integer id)
    {
        rentalRepository.deleteById(id);
    }

    public BigDecimal getTotalCost(Integer id)
    {
        Rental rental = rentalRepository.findByRentalID(id);
        Vehicle vehicle = rental.getVehicle();
        BigDecimal deposit = vehicle.getDepositAmount();
        BigDecimal balance = rental.getBalance();
        BigDecimal totalCost = deposit.add(balance);

        return totalCost;

        //LocalDateTime rentalDuration = getDuration() --> + any conversions if necessary

        //BigDecimal rentalCost = vehicle.getDayRate/HourlyRate*rentalDuration ++ if statements when necessary

        //BigDecimal totalCost = deposit + rentalCost
    }

    public double calculateRentalCost(Integer id)
    {
        Rental rental = rentalRepository.findByRentalID(id);
        Vehicle vehicle = rental.getVehicle();
        BigDecimal dailyRate = vehicle.getDailyRate();
        BigDecimal hourlyRate = vehicle.getHourlyRate();

        double rentalCost = 2.5;
        return rentalCost;
    }

    public void makePayment(Integer id, Rental rental, BigDecimal payment)
    {
        BigDecimal balance = rental.getBalance();
        BigDecimal newBalance = balance.subtract(payment);

        rental.setBalance(newBalance);

        rentalRepository.save(rental);
    }
}
