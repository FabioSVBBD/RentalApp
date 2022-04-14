package com.rental.rentalApp.entities;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Employee extends Person{
    
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer employeeID;

    @Column(name = "dateOfEmployment")
    private LocalDateTime dateOfEmployment;

    protected Employee(){}

    Employee(String name, String surname, String number, LocalDateTime dateOfEmployment){
    	super(name, surname, number);
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public String toString() {
        return "Employee [ id = "+ employeeID +", name = "+name+", surname = "+surname+", phone="+ number +", dateOfEmployment = "+dateOfEmployment+" ]";
    }

    
    public LocalDateTime getDateOfEmployment() { return this.dateOfEmployment; }

    public void setDateOfEmployment(LocalDateTime dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }
}
