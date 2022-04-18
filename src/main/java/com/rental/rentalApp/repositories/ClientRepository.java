package com.rental.rentalApp.repositories;

import com.rental.rentalApp.entities.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Integer> {
    List<Client> findByName(String name);
		List<Client> findBySurname(String surname);
		List<Client> findByEmail(String email);
		List<Client> findByNumber(String number);

		long deleteByEmail(String email);
		long deleteByNumber(String number);
}
