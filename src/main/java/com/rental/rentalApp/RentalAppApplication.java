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
  
  @Bean
	public CommandLineRunner getAllStatuses(StatusRepository repo) {
		return (args) -> {
			System.out.println("Statuses");

			for (Status status : repo.findAll()) {
				System.out.println(status);
			}
		};
	}

  @Bean
	public CommandLineRunner getAllColors(ColorRepository repo) {
		return (args) -> {
			System.out.println("Colors");

			for (Color color : repo.findAll()) {
				System.out.println(color);
			}
		};
	}

  @Bean
	public CommandLineRunner getAllBrands(BrandRepository repo) {
		return (args) -> {
			System.out.println("Brands");

			for (Brand brand: repo.findAll()) {
				System.out.println(brand);
			}
		};
	}

  @Bean
	public CommandLineRunner getAllModels(ModelRepository repo) {
		return (args) -> {
			System.out.println("Models");

			for (Model model : repo.findAll()) {
				System.out.println(model);
			}
		};
	}

	@Bean
	public CommandLineRunner getAllReviews(ReviewRepository repo) {
		return (args) -> {
			System.out.println("Reviews");

			for (Review review : repo.findAll()) {
				System.out.println(review);
			}
		};
	}

	@Bean
	public CommandLineRunner getAllEmployees(EmployeeRepository repo) {
		return (args) -> {
			System.out.println("Employees");

			for (Employee employee : repo.findAll()) {
				System.out.println(employee);
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

	@Bean
	public CommandLineRunner getAllPayments(PaymentMethodRepository PMrepo) {
		return(args) -> {
			System.out.println("Payment information");
			for(PaymentMethod method : PMrepo.findAll()) {
				System.out.println(method);
			}
		};
	}

	public CommandLineRunner getAllVehicleTypes(VehicleTypeRepository VHrepo) {
		return(args) -> {
			System.out.println("Vehicle Types");
			for(VehicleType type : VHrepo.findAll()) {
				System.out.println(type);
			}
		};
	}

}
