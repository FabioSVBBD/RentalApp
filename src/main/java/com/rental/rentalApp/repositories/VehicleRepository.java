package com.rental.rentalApp.repositories;

import com.rental.rentalApp.entities.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
    List<Vehicle> findByVIN(String VIN);

    List<Vehicle> findByAvailable(Boolean Available);

    long deleteByVin(String VIN);
    List<Vehicle> findAll();
    
    // @Query("SELECT a FROM Article a WHERE a.title=:title and a.category=:category")
    // List<Vehicle> fetchAvailable(@Param("available") Boolean available);
}
