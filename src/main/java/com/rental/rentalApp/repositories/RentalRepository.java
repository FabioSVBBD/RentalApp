package com.rental.rentalApp.repositories;

import com.rental.rentalApp.entities.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends CrudRepository<Rental, Integer> {
    List<Rental> findByAddress(String address);
    Rental findByRentalID(Integer id);
}
