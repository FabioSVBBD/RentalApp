package com.rental.rentalApp.controller;

import com.rental.rentalApp.entities.Employee;
import com.rental.rentalApp.repositories.EmployeeRepository;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rental-app/api/employees")
public class EmployeeController {

	@Autowired
	private final EmployeeRepository employeeRepository;

	private EmployeeController(EmployeeRepository repository) {
		this.employeeRepository = repository;
	}

	@GetMapping("")
	public ResponseEntity<Iterable<Employee>> getAllEmployees(@RequestParam(required = false) String name,
			@RequestParam(required = false) String surname,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfEmployment,
			@RequestParam(required = false) String number) {

		if (name != null && surname == null) {
			return ResponseEntity.ok(employeeRepository.findByName(name));
		} else if (surname != null && name == null) {
			return ResponseEntity.ok(employeeRepository.findBySurname(surname));
		} else if (number != null) {
			return ResponseEntity.ok(employeeRepository.findByNumber(number));
		} else if (surname != null && name != null) {
			return ResponseEntity.ok(employeeRepository.findByNameOrSurname(name, surname));
		} else if (dateOfEmployment != null) {
			return ResponseEntity.ok(employeeRepository.findByDateOfEmployment(dateOfEmployment));
		}

		return ResponseEntity.ok(employeeRepository.findAll());

	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
		Employee employee = employeeRepository.findById(id).get();

		if (employee != null) {
			return ResponseEntity.ok(employee);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/since")
	public ResponseEntity<Iterable<Employee>> insertEmployee(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfEmployment) {
		Iterable<Employee> employees = employeeRepository.findByDateOfEmploymentGreaterThanEqual(dateOfEmployment);

		if (!employees.iterator().hasNext()) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(employees);
	}

	@PostMapping("")
	public ResponseEntity<String> insertEmployee(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
			@RequestBody Employee employee) {

		if (startDate == null || employeeRepository.findByNumber(employee.getNumber()).size() != 0) {
			return ResponseEntity.badRequest().build();
		} else {
			employee.setDateOfEmployment(startDate);
			employeeRepository.save(employee);
		}

		return ResponseEntity
				.ok(String.format("%s %s saved successfully", employee.getName(), employee.getSurname(), employee.getNumber()));

	}

	@PatchMapping("")
	public ResponseEntity<String> updateEmployee(
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @RequestParam() Integer id,
			@RequestBody Employee updateEmployee) {
		StringBuilder response = new StringBuilder();
		Employee employee = employeeRepository.findById(id).get();

		if (employee == null) {
			return ResponseEntity.badRequest().build();
		}

		if (updateEmployee.getName() != null) {
			employee.setName(updateEmployee.getName());
			response.append(String.format("Name Updated: %s\n", updateEmployee.getName()));
		}

		if (updateEmployee.getSurname() != null) {
			employee.setSurname(updateEmployee.getSurname());
			response.append(String.format("Surname Updated: %s\n", updateEmployee.getSurname()));
		}

		if (updateEmployee.getDateOfEmployment() != null) {
			employee.setDateOfEmployment(startDate);
			response.append(String.format("E-mail Updated: %s\n", startDate));
		}

		if (updateEmployee.getNumber() != null) {
			employee.setNumber(updateEmployee.getNumber());
			response.append(String.format("Number Updated: %s\n", updateEmployee.getNumber()));
		}

		employeeRepository.save(updateEmployee);

		return ResponseEntity.ok(response.toString());
	}

}
