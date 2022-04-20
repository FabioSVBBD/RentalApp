package com.rental.rentalApp;

import com.rental.rentalApp.entities.*;
import com.rental.rentalApp.repositories.*;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RentalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalAppApplication.class, args);
	}

}
