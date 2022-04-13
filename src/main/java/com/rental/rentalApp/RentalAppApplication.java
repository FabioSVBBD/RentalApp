package com.rental.rentalApp;

import com.rental.rentalApp.entities.*;
import com.rental.rentalApp.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

	// Writes all vehicles to command line [REMOVE]
	@Bean
	public CommandLineRunner getAllVehicles(VehicleRepository repo) {
		return (args) -> {
			System.out.println("Vehicles");
			for (Vehicle vehicle : repo.findAll()) {
				System.out.println(vehicle);
			}
		};
	}

}
