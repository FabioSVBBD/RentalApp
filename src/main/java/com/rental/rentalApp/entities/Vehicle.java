package com.rental.rentalApp.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Year;
import java.util.Date;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vehicleID;

    @Column(name = "VIN")
    private String VIN;

    @Column(name = "BrandID")
    private int brandID;

    @Column(name = "ModelID")
    private int modelID;

    @Column(name = "VehicleTypeID")
    private int vehicleTypeID;

    @Column(name = "ColorID")
    private int colourID;

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

    protected Vehicle() { }

    public Vehicle(
        String VIN,
        int brandID,
        int modelID,
        int vehicleTypeID,
        int colourID,
        int numSeats,
        BigDecimal dailyRate,
        BigDecimal hourlyRate,
        int yearPurchased,
        Date lastService,
        char transmission,
        BigDecimal mileage,
        BigDecimal depositAmount,
        boolean available
    ) {
        this.setVIN(VIN);
        this.setBrandID(brandID);
        this.setModel(modelID);
        this.setVehicleType(vehicleTypeID);
        this.setColour(colourID);
        this.setNumSeats(numSeats);
        this.setDailyRate(dailyRate);
        this.setHourlyRate(hourlyRate);
        this.setYearPurchased(yearPurchased);
        this.setLastService(lastService);
        this.setTransmission(transmission);
        this.setMileage(mileage);
        this.setDepositAmount(depositAmount);
        this.setAvailable(available);
    }

    @Override
    public String toString() {
        return String.format("Vehicle [ id = %d, VIN = %s, brandID = %d, modelID = %d, vehicleTypeID = %d, colourID = %d," +
                        " numSeats: %d, dailyRate: %s, hourlyRate: %s, yearPurchased: %d, lastService: %s, transmission: %c," +
                        " mileage: %s, depositAmount: %s, available: %s]",
                this.vehicleID, this.VIN, this.brandID, this.modelID, this.vehicleTypeID, this.colourID, this.numSeats, this.dailyRate,
                this.hourlyRate, this.yearPurchased, this.lastService, this.transmission, this.mileage, this.depositAmount, this.available);
    }

    public String getVIN() { return VIN; }
    public int getBrandID() { return brandID; }
    public int getModel() { return modelID; }
    public int getVehicleType() { return vehicleTypeID; }
    public int getColour() { return colourID; }
    public int getNumSeats() { return numSeats; }
    public BigDecimal getDailyRate() { return dailyRate; }
    public BigDecimal getHourlyRate() { return hourlyRate; }
    public int getYearPurchased() { return yearPurchased; }
    public Date getLastService() { return lastService; }
    public char getTransmission() { return transmission; }
    public BigDecimal getMileage() { return mileage; }
    public BigDecimal getDepositAmount() { return depositAmount; }
    public boolean isAvailable() { return available; }

    public void setVIN(String VIN) { this.VIN = VIN; }
    public void setBrandID(int brandID) { this.brandID = brandID; }
    public void setModel(int model) { this.modelID = model; }
    public void setVehicleType(int vehicleType) { this.vehicleTypeID = vehicleType; }
    public void setColour(int colour) { this.colourID = colour; }
    public void setNumSeats(int numSeats) { this.numSeats = numSeats; }
    public void setDailyRate(BigDecimal dailyRate) { this.dailyRate = dailyRate; }
    public void setHourlyRate(BigDecimal hourlyRate) { this.hourlyRate = hourlyRate; }
    public void setYearPurchased(int yearPurchased) { this.yearPurchased = yearPurchased; }
    public void setLastService(Date lastService) { this.lastService = lastService; }
    public void setTransmission(char transmission) { this.transmission = transmission; }
    public void setMileage(BigDecimal mileage) { this.mileage = mileage; }
    public void setDepositAmount(BigDecimal depositAmount) { this.depositAmount = depositAmount; }
    public void setAvailable(boolean available) { this.available = available; }
}
