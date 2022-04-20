package com.rental.rentalApp.entities;

import javax.persistence.*;

@Entity
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int modelID;

    @Column(name = "ModelName")
    private String modelName;

    @Column(name = "Year")
    private Integer year;

    protected Model() { }

    public Model(String modelName, Integer year) {
      this.setModelName(modelName);
      this.setYear(year);
  }

  @Override
  public String toString() {
      return String.format("Model => ID: "+ modelID +" ModelName: " + modelName + " Year: " + year);
  }

  public String getModelName() { return this.modelName; }

  public Integer getYear() { return this.year; }

  public void setModelName(String modelName) {
      this.modelName = modelName;
  }

  public void setYear(Integer year) {
    this.year = year;
}
}
