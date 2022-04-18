package com.rental.rentalApp.controller;

import com.rental.rentalApp.entities.*;
import com.rental.rentalApp.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping("rental-app/get-payment-methods")
    public ResponseEntity<Iterable<PaymentMethod>> getPaymentMethods()
    {
        return ResponseEntity.ok(paymentMethodService.getPaymentMethods());
    }

    @GetMapping("rental-app/{id}/get-payment-by-id")
    public ResponseEntity<PaymentMethod> getPaymentMethod(@PathVariable Integer id)
    {
        Optional<PaymentMethod> optionalPaymentMethod = paymentMethodService.getPaymentMethodbyID(id);

        System.out.println(optionalPaymentMethod);

        if(optionalPaymentMethod.isPresent())
        {
            return ResponseEntity.ok(optionalPaymentMethod.get());
        }
        else return ResponseEntity.noContent().build();
    }
}
