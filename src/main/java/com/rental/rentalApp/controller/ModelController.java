package com.rental.rentalApp.controller;

import java.util.*;

import com.rental.rentalApp.entities.Brand;
import com.rental.rentalApp.entities.Model;
import com.rental.rentalApp.repositories.BrandRepository;
import com.rental.rentalApp.repositories.ModelRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rental-app/api/models")
public class ModelController {

  private final ModelRepository modelRepository;
  private final BrandRepository brandRepository;

	private ModelController(ModelRepository _modelRepository, BrandRepository _brandRepository) {
		this.modelRepository = _modelRepository;
    this.brandRepository = _brandRepository;
	}

  // Get all Models
	@GetMapping("")
  ResponseEntity<List<Model>> getModels(@RequestParam(required = false) String brand) {

    if (brand != null) {
      Brand brandObj = brandRepository.findByBrandName(brand);

      if (brandObj != null) {
        List<Model> brandList = modelRepository.findByBrand(brandObj);
        return ResponseEntity.ok(brandList);
      }
    }
    return ResponseEntity.ok(modelRepository.findAll());
  }
}