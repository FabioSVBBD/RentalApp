package com.rental.rentalApp.entities;

import javax.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {
	@Column(name = "Name")
	protected String name;

	@Column(name = "Surname")
	protected String surname;

	@Column(name = "Phone")
	protected String number;
}
