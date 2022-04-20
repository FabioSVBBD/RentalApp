package com.rental.rentalApp.entities;

import javax.persistence.*;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Retry;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int modelID;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "BrandID", nullable = false)
    private Brand brand;

    @Column(name = "ModelName")
    private String modelName;

    @Column(name = "Year")
    private Integer year;

    protected Model() { }

    public Model(Brand brand, String modelName, Integer year) {
      this.setBrand(brand);
      this.setModelName(modelName);
      this.setYear(year);
  }

  @Override
  public String toString() {
      return String.format("Model => ID: "+ modelID +" Brand Details => "+ this.brand +" ModelName: " + modelName + " Year: " + year);
  }

  public Brand getBrand() { return this.brand; }
  public String getModelName() { return this.modelName; }

  public Integer getYear() { return this.year; }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public void setModelName(String modelName) {
      this.modelName = modelName;
  }

  public void setYear(Integer year) {
    this.year = year;
}
}
