package com.rental.rentalApp.controller;

import java.util.*;

import com.rental.rentalApp.entities.Vehicle;
import com.rental.rentalApp.repositories.VehicleRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rental-app/api/vehicles")
public class VehicleController {

	private final VehicleRepository vehicleRepository;

	private VehicleController(VehicleRepository repository) {
		this.vehicleRepository = repository;
	}

	@PatchMapping("{id}")
	public ResponseEntity<String> patchVehicle(@PathVariable Integer id, @RequestBody Vehicle newData) {
		StringBuilder response = new StringBuilder();

		Vehicle vehicle = vehicleRepository.findById(id).get();

		if (vehicle == null) {
			return ResponseEntity.badRequest().build();
		}

		if (newData.getLastService() != null) {
			vehicle.setLastService(newData.getLastService());
			response.append(String.format("Vehicle last serviced on: " + newData.getLastService() + "\n"));
		}

		if (newData.getDepositAmount() != null) {
			vehicle.setDepositAmount(newData.getDepositAmount());
			response.append(String.format("Deposit for vehicle updated: " + newData.getDepositAmount() + "\n"));
		}

		if (newData.getHourlyRate() != null) {
			vehicle.setHourlyRate(newData.getHourlyRate());
			response.append(String.format("Hourly rate for vehicle updated: " + newData.getHourlyRate() + "\n"));
		}

		if (newData.getDailyRate() != null) {
			vehicle.setDailyRate(newData.getDailyRate());
			response.append(String.format("Daily rate for vehicle updated: " + newData.getDailyRate() + "\n"));
		}

		if (newData.getMileage() != null) {
			vehicle.setMileage(newData.getMileage());
			response.append(String.format("Mileage for vehicle updated: " + newData.getMileage() + "\n"));
		}

		vehicle.setAvailable(newData.isAvailable());
		response.append(String.format("Availablity for vehicle updated: " + newData.isAvailable() + "\n"));

		return ResponseEntity.ok(response.toString());
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable Integer id, @RequestParam Optional<String> token) {
		final String securityKey = "g2G7aoTyqQeDG4liY5ZmBAQr8V7M4v3BKSeUNd5u";

		if (token.isPresent() && token.get().equals(securityKey)) {
			Vehicle vehicle = vehicleRepository.findById(id).get();
			vehicleRepository.deleteById(id);

			return ResponseEntity.ok(String.format("Deleted " + vehicle.getVIN()));
		}

		return ResponseEntity.badRequest().build();
	}

	@GetMapping("")
	ResponseEntity<List<Vehicle>> getAllVehicles(@RequestParam(required = false) Boolean available) {

		if (available != null) {
			return ResponseEntity.ok(vehicleRepository.findByAvailable(available));
		}

		return ResponseEntity.ok(vehicleRepository.findAll());
	}

	@PostMapping("")
	ResponseEntity<String> newVehicle(@RequestBody Vehicle newVehicle) {

		if (newVehicle == null || vehicleRepository.findByVIN(newVehicle.getVIN()) != null) {
			return ResponseEntity.badRequest().build();
		} else {
			vehicleRepository.save(newVehicle);
		}

		return ResponseEntity.ok(String.format("Vehicle %s added", newVehicle.getVIN()));
	}

	@GetMapping("{id}")
	ResponseEntity<Vehicle> getVehicle(@PathVariable int id) {

		Vehicle vehicle = vehicleRepository.findById(id).get();

		if (vehicle == null) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(vehicle);
	}
}