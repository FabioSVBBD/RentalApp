package com.rental.rentalApp.repositories;

import com.rental.rentalApp.entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RentalRepository extends CrudRepository<Rental, Integer> {
	List<Rental> findByAddress(String address);

	Rental findByRentalID(Integer id);

	List<Rental> findByStatus(Status status);

	List<Rental> findByClient(Client client);

	List<Rental> findByEmployee(Employee employee);

	List<Rental> findByVehicle(Vehicle vehicle);
}
