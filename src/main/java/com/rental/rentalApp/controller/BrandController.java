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

  // Get a single brand
  @GetMapping("{id}")
  ResponseEntity<Brand> getBrand(@PathVariable int id) {
    Brand brand = brandRepository.findById(id).get();

    if(brand == null){
      return ResponseEntity.badRequest().build();
    }

    return ResponseEntity.ok(brand);
  }

    // Get all brands
	@GetMapping("")
  ResponseEntity<List<Brand>> getAllBrands() {
    return ResponseEntity.ok(brandRepository.findAll());
  }

  // new Brand
  @PostMapping("")
	ResponseEntity<String> newBrand(@RequestBody Brand newBrand){

		if (newBrand == null ) {
			return ResponseEntity.badRequest().build();
		}
    brandRepository.save(newBrand);
		return ResponseEntity.ok(String.format("Brand %s added", newBrand.getBrandName()));
	}
}