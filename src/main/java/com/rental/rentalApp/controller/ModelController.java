package com.rental.rentalApp.controller;

import java.util.*;

import com.rental.rentalApp.entities.Model;
import com.rental.rentalApp.entities.Brand;
import com.rental.rentalApp.repositories.ModelRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rental-app/api/models")
public class ModelController {

  private final ModelRepository modelRepository;

	private ModelController(ModelRepository repository) {
		this.modelRepository = repository;
	}

  // Get all Models
	@GetMapping("")
  ResponseEntity<List<Model>> getAllModels() {
    return ResponseEntity.ok(modelRepository.findAll());
  }

  // Get models given Model name
  @GetMapping("")
  ResponseEntity<List<Model>> getModel(String modelName) {
    return ResponseEntity.ok(modelRepository.findByModelName(modelName));
  }

  // Get models given Brand name
  @GetMapping("")
  ResponseEntity<List<Model>> getModelsInBrand(Integer brandID) {
    return ResponseEntity.ok(modelRepository.findByBrandID(brandID));
  }

}