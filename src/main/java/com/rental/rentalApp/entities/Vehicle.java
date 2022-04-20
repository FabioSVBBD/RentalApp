package com.rental.rentalApp.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleID;

    @Column(name = "VIN")
    private String VIN;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "ModelID", nullable = false)
    private Model model;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "VehicleTypeID", nullable = false)
    private VehicleType vehicleType;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "ColorID", nullable = false)
    private Color color;

    @Column(name = "NumSeats")
    private int numSeats;

    @Column(name = "DayRate")
    private BigDecimal dailyRate;

    @Column(name = "hourlyRate")
    private BigDecimal hourlyRate;

    @Column(name = "YearPurchased")
    private int yearPurchased;

    @Column(name = "LastService")
    private Date lastService;

    @Column(name = "Transmission")
    private char transmission;

    @Column(name = "Mileage")
    private BigDecimal mileage;

    @Column(name = "DepositAmount")
    private BigDecimal depositAmount;

    @Column(name = "Available")
    private boolean available;

    @Override
    public String toString() {
        return String.format("Vehicle [[ id = %d, VIN = %s, model = [ %s ], vehicleType = [ %s ], color = [ %s ]," +
                        " numSeats: %d, dailyRate: %s, hourlyRate: %s, yearPurchased: %d, lastService: %s, transmission: %c," +
                        " mileage: %s, depositAmount: %s, available: %s ]]",
                this.vehicleID, this.VIN, this.model, this.vehicleType, this.color, this.numSeats, this.dailyRate,
                this.hourlyRate, this.yearPurchased, this.lastService, this.transmission, this.mileage, this.depositAmount, this.available);
    }
}
