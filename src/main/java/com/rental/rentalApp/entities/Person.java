package com.rental.rentalApp.entities;

import javax.persistence.*;

@MappedSuperclass
public class Person {

	@Column(name = "Name")
	protected String name;

	@Column(name = "Surname")
	protected String surname;

	@Column(name = "Phone")
	protected String number;

	protected Person() {}

	public Person(String name, String surname, String number) {
		this.setName(name);
		this.setSurname(surname);
		this.setNumber(number);
	}

	public String getName() { return this.name; }
	public String getSurname() { return this.surname; }
	public String getNumber() { return this.number; }

	public void setName(String name) {
			this.name = name;
	}

	public void setSurname(String surname) {
			this.surname = surname;
	}

	public void setNumber(String number) {
			this.number = number;
	}
}
