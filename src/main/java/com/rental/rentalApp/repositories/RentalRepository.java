package com.rental.rentalApp.repositories;

import com.rental.rentalApp.entities.Rental;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface RentalRepository extends CrudRepository<Rental, Integer> {
    List<Rental> findByAddress(String address);
}
