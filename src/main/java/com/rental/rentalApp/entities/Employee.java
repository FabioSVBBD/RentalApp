package com.rental.rentalApp.entities;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EmployeeID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "PhoneNo")
    private String phoneNo;

    @Column(name = "dateOfEmployment")
    private LocalDateTime dateOfEmployment;

    protected Employee(){}

    Employee(String name, String surname, String phoneNo, LocalDateTime dateOfEmployment){
        this.name = name;
        this.surname = surname;
        this.phoneNo = phoneNo;
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public String toString() {
        return "Employee [ id = "+id+", name = "+name+", surname = "+surname+", phoneNo="+phoneNo+", dateOfEmployment = "+dateOfEmployment+" ]";
    }

    // Accessors
    public String getName() { return this.name; }
    public String getSurname() { return this.surname; }
    public String getPhoneNo() { return this.phoneNo; }
    public LocalDateTime getDateOfEmployment() { return this.dateOfEmployment; }

    // Mutators
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setDateOfEmployment(LocalDateTime dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }
}
