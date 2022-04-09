package com.rental.rentalApp;

import com.rental.rentalApp.entities.Client;
import com.rental.rentalApp.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner getAllClients(ClientRepository repo) {
		if (repo.findByName("Jane").isEmpty()) {
			repo.save(new Client("Jane", "Johnson", "janejohnson@gmail.com", "0824563433"));
		}

		return (args) -> {
			System.out.println("Clients");

			for (Client client : repo.findAll()) {
				System.out.println(client);
			}

			System.out.println(String.format("Client with name 'Jane': %s", repo.findByName("Jane").toString()));
		};
	}
}
