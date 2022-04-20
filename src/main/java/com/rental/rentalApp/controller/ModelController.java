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

  // Get Single Model
  @GetMapping("{id}")
  ResponseEntity<Model> getModel(@PathVariable int id) {
    Model model = modelRepository.findById(id).get();

    if(model == null){
      return ResponseEntity.badRequest().build();
    }

    return ResponseEntity.ok(model);
  }

  // Get all Models
	@GetMapping("")
  ResponseEntity<List<Model>> getModels(@RequestParam(required = false) String brand, @RequestParam(required = false) Integer brandId) {

    if (brand != null) {
      Brand brandObj = brandRepository.findByBrandName(brand);

      if (brandObj != null) {
        List<Model> brandList = modelRepository.findByBrand(brandObj);
        return ResponseEntity.ok(brandList);
      }
      return ResponseEntity.badRequest().build();
    }
    else if(brandId != null){
      Brand brandObj = brandRepository.findById(brandId).get();

      if(brandObj != null){
        return ResponseEntity.ok(modelRepository.findByBrand(brandObj));
      }
      return ResponseEntity.badRequest().build();
    }
    return ResponseEntity.ok(modelRepository.findAll());
  }

  // New Model
  @PostMapping("")
	ResponseEntity<String> newModel(@RequestBody Model newModel){

		if (newModel == null ) {
			return ResponseEntity.badRequest().build();
		}
    modelRepository.save(newModel);
		return ResponseEntity.ok(String.format("Model %s added", newModel.getModelName()));
	}
}