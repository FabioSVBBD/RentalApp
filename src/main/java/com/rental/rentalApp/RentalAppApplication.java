package com.rental.rentalApp;

import com.rental.rentalApp.entities.*;
import com.rental.rentalApp.repositories.*;
import com.rental.rentalApp.services.*;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.Duration;

@SpringBootApplication
public class RentalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalAppApplication.class, args);
	}
//
//	@Bean
//	public CommandLineRunner getTotalCost(RentalService rentalService)
//	{
//		return (args) -> {
//			System.out.println("Total Cost");
//			Duration duration = rentalService.getDuration(1);
//			System.out.println(duration);
//		};
//	}

}
