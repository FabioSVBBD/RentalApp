package com.rental.rentalApp.services;

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
}
