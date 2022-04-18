package com.rental.rentalApp.services;

import com.rental.rentalApp.entities.PaymentMethod;
import com.rental.rentalApp.repositories.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    @Autowired
    public PaymentMethodService(PaymentMethodRepository paymentMethods)
    {
        this.paymentMethodRepository = paymentMethods;
    }

    public List<PaymentMethod> getPaymentMethods()
    {
        List<PaymentMethod> paymentMethods = new ArrayList<>();
        paymentMethodRepository.findAll()
                .forEach(paymentMethods::add);
        return paymentMethods;
    }

    public Optional<PaymentMethod> getPaymentMethodbyID(Integer id)
    {
        Optional<PaymentMethod> paymentMethod = paymentMethodRepository.findById(id);
        return paymentMethod;
    }
}
