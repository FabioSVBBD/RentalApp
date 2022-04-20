package com.rental.rentalApp.controller;

import com.rental.rentalApp.entities.Status;
import com.rental.rentalApp.repositories.StatusRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rental-app/api/status")
public class StatusController {

	private StatusRepository statusRepository;

	public StatusController(StatusRepository statusRepository) {
		this.statusRepository = statusRepository;
	}

	@PatchMapping("{statusID}/{status}/update-status")
	public ResponseEntity<String> updateStatus(@PathVariable Integer statusID, @PathVariable String status) {
		if (statusRepository.findById(statusID).isPresent()) {
			statusRepository.findById(statusID).get().setStatus(status);
			return ResponseEntity.ok(String.format("Status updated successfully: %s", status));
		} else
			return ResponseEntity.badRequest().build();
	}

	@GetMapping("{status}")

	public Status getStatus(@PathVariable String status) {
		return statusRepository.findByStatus(status);
	}
}
