package com.rental.rentalApp.repositories;

import com.rental.rentalApp.entities.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StatusRepository extends CrudRepository<Status,Integer> {
    List<Status> findByStatus(String status);
    Optional<Status> findById(Integer StatusID);

    @Override
   Status save(Status status);
}
