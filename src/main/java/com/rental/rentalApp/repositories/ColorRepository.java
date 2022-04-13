package com.rental.rentalApp.repositories;

import com.rental.rentalApp.entities.Color;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ColorRepository extends CrudRepository<Color, Integer> {
  List<Color> findByColorName(String colorName);
}
