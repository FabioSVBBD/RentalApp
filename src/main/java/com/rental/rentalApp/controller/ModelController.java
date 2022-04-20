package com.rental.rentalApp.controller;

import java.util.*;

import com.rental.rentalApp.entities.Model;
import com.rental.rentalApp.entities.Brand;
import com.rental.rentalApp.repositories.ModelRepository;
import com.rental.rentalApp.repositories.BrandRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rental-app/api/models")
public class ModelController {

  private final ModelRepository modelRepository;
  private final BrandRepository brandRepository;

	private ModelController(ModelRepository _modelRepository, BrandRepository _brandRepository) {
		this.modelRepository = _modelRepository;
    this.brandRepository = _brandRepository ;
	}

  @GetMapping("")
  public ResponseEntity<Iterable<Model>> getAllModels(  @RequestParam(required = false) String modelName, 
                                                        @RequestParam(required = false) Integer brandId ) {

    if(brandId != null){
      Brand brand = this.brandRepository.findById(brandId).get() ;

      if(brand != null){
        return ResponseEntity.ok(modelRepository.findByBrand(brand));
      }
      
      return ResponseEntity.badRequest().build();
      
    }

    if(modelName != null){
      return ResponseEntity.ok(modelRepository.findByModelName(modelName));
    }

    return ResponseEntity.ok(modelRepository.findAll());
  }

}