package com.rental.rentalApp.entities;

import javax.persistence.*;

@Entity
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int VehicleTypeID;

    @Column(name = "Type")
    private String type;

    protected VehicleType() { }

    public VehicleType(String type)
    {
        this.setType(type);
    }

    @Override
    public String toString()
    {
        return "Vehicle Type [ ID = " + VehicleTypeID + ", Type = " + type + "]";
    }

    public String getType(String type)
    {
        return this.type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
