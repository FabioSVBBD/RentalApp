package com.rental.rentalApp.entities;

import javax.persistence.*;

@Entity
public class Client extends Person {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		protected Integer clientID;

    @Column(name = "Email")
    private String email;

    protected Client() { }

    public Client(String name, String surname, String email, String number) {
        super(name, surname, number);
				this.setEmail(email);
    }

    @Override
    public String toString() {
        return String.format("Client [ id = %d, name = %s, surname= %s, email= %s, phone = %s ]",
                clientID, name, surname, email, number);
    }

    public String getEmail() { return this.email; }

    public void setEmail(String email) {
        this.email = email;
    }
}
