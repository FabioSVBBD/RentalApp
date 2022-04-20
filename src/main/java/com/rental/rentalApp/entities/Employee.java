package com.rental.rentalApp.entities;

import lombok.Data;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Data
public class Employee extends Person{

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer employeeID;
    
    @Column(name = "dateOfEmployment")
    private LocalDate dateOfEmployment;

    @Override
    public String toString() {
        return "Employee [ id = "+ employeeID +", name = "+name+", surname = "+surname+", phone="+ number +", dateOfEmployment = "+dateOfEmployment+" ]";
    }
}
