package com.rental.rentalApp.entities;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Client extends Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clientID;

	@Column(name = "Email")
	private String email;
}
