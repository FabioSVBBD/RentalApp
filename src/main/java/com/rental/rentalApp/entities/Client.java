package com.rental.rentalApp.entities;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ClientID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String number;

    protected Client() { }

    public Client(String name, String surname, String email, String number) {
        this.setName(name);
        this.setSurname(surname);
        this.setEmail(email);
        this.setName(number);
    }

    @Override
    public String toString() {
        return String.format("Client [ id = %d, name = %s, surname= %s, email= %s, phone = %s ]",
                ClientID, name, surname, email, number);
    }

    public String getName() { return this.name; }
    public String getSurname() { return this.surname; }
    public String getEmail() { return this.email; }
    public String getNumber() { return this.number; }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
