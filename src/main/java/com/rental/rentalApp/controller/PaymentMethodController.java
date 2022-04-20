package com.rental.rentalApp.controller;

import com.rental.rentalApp.entities.*;
import com.rental.rentalApp.repositories.PaymentMethodRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("rental-app/api/payment-methods")
public class PaymentMethodController {

	private final PaymentMethodRepository paymentMethodRepository;

	public PaymentMethodController(PaymentMethodRepository paymentMethodRepository) {
		this.paymentMethodRepository = paymentMethodRepository;
	}

	@GetMapping("")
	public ResponseEntity<Iterable<PaymentMethod>> getPaymentMethods() {
		return ResponseEntity.ok(paymentMethodRepository.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<PaymentMethod> getPaymentMethod(@PathVariable Integer id) {
		Optional<PaymentMethod> optionalPaymentMethod = paymentMethodRepository.findById(id);

		if (optionalPaymentMethod.isPresent()) {
			return ResponseEntity.ok(optionalPaymentMethod.get());
		} else
			return ResponseEntity.noContent().build();
	}
}
