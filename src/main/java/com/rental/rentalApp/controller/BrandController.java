package com.rental.rentalApp.controller;

import java.util.*;

import com.rental.rentalApp.entities.Brand;
import com.rental.rentalApp.repositories.BrandRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rental-app/api/brands")
public class BrandController {

    private final BrandRepository brandRepository;

	private BrandController(BrandRepository repository) {
		this.brandRepository = repository;
	}

    // Get all brands
	@GetMapping("")
    ResponseEntity<List<Brand>> getAllBrands() {
		return ResponseEntity.ok(brandRepository.findAll());
    }
}