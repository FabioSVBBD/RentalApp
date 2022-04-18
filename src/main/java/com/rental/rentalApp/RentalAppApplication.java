package com.rental.rentalApp;

import com.rental.rentalApp.entities.*;
import com.rental.rentalApp.repositories.*;
import com.rental.rentalApp.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class RentalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalAppApplication.class, args);
	}

	// Writes all clients to command line [REMOVE]
	@Bean
	public CommandLineRunner getAllClients(ClientRepository repo) {
		return (args) -> {
			System.out.println("Clients");
			for (Client client : repo.findAll()) {
				System.out.println(client);
			}
		};
	}

	@Bean
	public CommandLineRunner getTotalCost(RentalService rentalService)
	{
		return (args) -> {
			System.out.println("Total Cost");
			BigDecimal cost = rentalService.getTotalCost(1);
			System.out.println();
		};
	}

}
