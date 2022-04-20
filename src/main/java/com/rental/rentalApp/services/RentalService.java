package com.rental.rentalApp.services;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.rental.rentalApp.entities.*;
import com.rental.rentalApp.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public List<Rental> getAllRentalsByClient(Client client) {
        return rentalRepository.findByClient(client);
    }

    public List<Rental> getAllRentalsByEmployee(Employee employee) {
        return rentalRepository.findByEmployee(employee);
    }

    public List<Rental> getAllRentalsByVehicle(Vehicle vehicle) {
        return rentalRepository.findByVehicle(vehicle);
    }

    public Optional<Rental> getRental(Integer id)
    {
        return rentalRepository.findById(id);
    }

    public void addRental(Rental rental)
    {
        rentalRepository.save(rental);
    }

    public void updateRental(Rental rental)
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

    public BigDecimal getRentalCost(Integer id)
    {
        Rental rental = rentalRepository.findByRentalID(id);
        Vehicle vehicle = rental.getVehicle();

        BigDecimal rentalCost;
        BigDecimal dailyRate = vehicle.getDailyRate();
        BigDecimal hourlyRate = vehicle.getHourlyRate();

        Duration totalRentalTime = getDuration(id);

        if(totalRentalTime.toHours() < 24)
        {
             System.out.println(totalRentalTime.toHours());
             rentalCost = hourlyRate.multiply(BigDecimal.valueOf(totalRentalTime.toHours()));
        }
        else
        {
             rentalCost = dailyRate.multiply(BigDecimal.valueOf(totalRentalTime.toDays()));
        }

        return rentalCost;
    }

    public void makePayment(Integer id, BigDecimal payment)
    {
        Rental rental = rentalRepository.findByRentalID(id);

        BigDecimal balance = rental.getBalance();
        BigDecimal newBalance = balance.subtract(payment);

        rental.setBalance(newBalance);

        rentalRepository.save(rental);
    }

    public Duration getDuration(Integer id) {
        Rental rental = rentalRepository.findByRentalID(id);
        return Duration.between(rental.getStartDate().toInstant(), rental.getEndDate().toInstant());
    }

}
