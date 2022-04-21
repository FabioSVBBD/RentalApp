package com.rental.rentalApp.repositories;

import com.rental.rentalApp.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	List<Employee> findByName(String name);

	List<Employee> findBySurname(String surname);

	List<Employee> findByNumber(String number);

	List<Employee> findByDateOfEmployment(LocalDate dateOfEmployment);

	List<Employee> findByDateOfEmploymentGreaterThanEqual(LocalDate dateOfEmployment);

	List<Employee> findByNameOrSurname(String name, String surname);

}