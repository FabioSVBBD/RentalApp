package com.rental.rentalApp.entities;

import javax.persistence.*;

@Entity
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PaymentMethodID;

    @Column(name = "MethodName")
    private String methodName;

    protected PaymentMethod() { }

    public PaymentMethod(String methodName)
    {
        this.setMethod(methodName);
    }

    @Override
    public String toString()
    {
        return "Payment Method [ ID = " + PaymentMethodID + ", Method = " + methodName + "]";
    }

    public String getMethod(String methodName)
    {
        return this.methodName;
    }

    public void setMethod(String methodName)
    {
        this.methodName = methodName;
    }
}
