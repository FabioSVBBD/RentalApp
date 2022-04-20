package com.rental.rentalApp.entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int modelID;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE })
	@JoinColumn(name = "BrandID", nullable = false)
	private Brand brand;

	@Column(name = "ModelName")
	private String modelName;

	@Column(name = "Year")
	private Integer year;

	@Override
	public String toString() {
		return String.format("Model => ID: " + modelID + " ModelName: " + modelName + " Year: " + year);
	}
}
