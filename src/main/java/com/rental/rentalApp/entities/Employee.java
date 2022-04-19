package com.rental.rentalApp.entities;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
public class Employee extends Person{
    
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer employeeID; 
    
    @Column(name = "dateOfEmployment")
    private LocalDate dateOfEmployment;

    protected Employee(){}

    Employee(String name, String surname, String number, LocalDate dateOfEmployment){
    	super(name, surname, number);
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public String toString() {
        return "Employee [ id = "+ employeeID +", name = "+name+", surname = "+surname+", phone="+ number +", dateOfEmployment = "+dateOfEmployment+" ]";
    }
    

    public LocalDate getDateOfEmployment() { return this.dateOfEmployment; }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }
}
