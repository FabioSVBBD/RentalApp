package com.rental.rentalApp.repositories;

import com.rental.rentalApp.entities.VehicleType;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface VehicleTypeRepository extends CrudRepository<VehicleType, Integer> {
    List<VehicleType> findByType(String type);
}
