package com.rental.rentalApp.controller;

import java.util.*;

import com.rental.rentalApp.entities.VehicleType;
import com.rental.rentalApp.repositories.VehicleTypeRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rental-app/api/vehicle-types")
public class VehicleTypeController {

    private final VehicleTypeRepository vehicleTypeRepository;

	private VehicleTypeController(VehicleTypeRepository repository) {
		this.vehicleTypeRepository = repository;
	}

    // Get all vehicle types
	@GetMapping("")
    ResponseEntity<List<VehicleType>> getAllVehicleTypes() {
		return ResponseEntity.ok(vehicleTypeRepository.findAll());
    }
    
}
