package com.rental.rentalApp.repositories;

import com.rental.rentalApp.entities.PaymentMethod;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Integer> {
    List<PaymentMethod> findByMethodName(String methodName);
}
