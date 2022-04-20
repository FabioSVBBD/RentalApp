package com.rental.rentalApp.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int BrandID;

	@Column(name = "BrandName")
	private String brandName;

	@Override
	public String toString() {
		return String.format("Brand => ID: " + BrandID + " BrandName: " + brandName);
	}
}
