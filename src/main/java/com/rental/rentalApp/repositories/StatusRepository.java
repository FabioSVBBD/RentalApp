package com.rental.rentalApp.repositories;

import com.rental.rentalApp.entities.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatusRepository extends CrudRepository<Status,Integer> {
    Status findByStatus(String status);
    Status save(Status status);
}
