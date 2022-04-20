package com.rental.rentalApp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PaymentMethodID;

    @Column(name = "MethodName")
    private String methodName;

    protected PaymentMethod() { }

    public PaymentMethod(String methodName)
    {
        this.setMethodName(methodName);
    }

    @Override
    public String toString()
    {
        return "Payment Method [ ID = " + PaymentMethodID + ", Method = " + methodName + "]";
    }

}
