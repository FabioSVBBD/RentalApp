package com.rental.rentalApp.entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Color {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ColorID;

	@Column(name = "ColorName")
	private String colorName;

	@Override
	public String toString() {
		return String.format("Color => ID: " + getColorID() + " ColorName: " + getColorName());
	}
}
