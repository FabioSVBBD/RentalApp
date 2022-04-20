package com.rental.rentalApp.controller;

import com.rental.rentalApp.entities.*;
import com.rental.rentalApp.services.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("rental-app/api/payment-method")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping("get-payment-methods")
    public ResponseEntity<Iterable<PaymentMethod>> getPaymentMethods()
    {
        return ResponseEntity.ok(paymentMethodService.getPaymentMethods());
    }

    @GetMapping("{id}/get-payment-by-id")
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
