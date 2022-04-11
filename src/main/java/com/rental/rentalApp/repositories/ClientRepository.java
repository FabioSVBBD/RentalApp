package com.rental.rentalApp.repositories;

import com.rental.rentalApp.entities.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    List<Client> findByName(String name);
}
