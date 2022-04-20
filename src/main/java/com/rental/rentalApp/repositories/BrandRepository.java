package com.rental.rentalApp.repositories;

import com.rental.rentalApp.entities.Brand;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BrandRepository extends CrudRepository<Brand, Integer> {
	Brand findByBrandName(String brandName);

	List<Brand> findAll();
}