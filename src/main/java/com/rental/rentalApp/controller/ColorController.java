package com.rental.rentalApp.controller;

import java.util.*;

import com.rental.rentalApp.entities.Color;
import com.rental.rentalApp.repositories.ColorRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rental-app/api/colors")
public class ColorController {

    private final ColorRepository colorRepository;

	private ColorController(ColorRepository repository) {
		this.colorRepository = repository;
	}

    // Get all colors
	@GetMapping("")
    ResponseEntity<List<Color>> getAllColors() {
		return ResponseEntity.ok(colorRepository.findAll());
    }
}