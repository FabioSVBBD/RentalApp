package com.rental.rentalApp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int VehicleTypeID;

    @Column(name = "Type")
    private String type;

    @Override
    public String toString()
    {
        return "Vehicle Type [ ID = " + VehicleTypeID + ", Type = " + type + "]";
    }

}
