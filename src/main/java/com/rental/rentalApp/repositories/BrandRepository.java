package com.rental.rentalApp.repositories;

import com.rental.rentalApp.entities.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandRepository extends CrudRepository<Brand, Integer> {
  List<Brand> findByBrandName(String brandName);
  List<Brand> findAll();
}