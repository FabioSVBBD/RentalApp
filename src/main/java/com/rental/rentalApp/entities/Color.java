package com.rental.rentalApp.entities;

import javax.persistence.*;

@Entity
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ColorID;

    @Column(name = "ColorName")
    private String colorName;

    protected Color() { }

    public Color(String colorName) {
      this.setColorName(colorName);
  }

  @Override
  public String toString() {
      return String.format("Color => ID: "+ ColorID +" ColorName: " + colorName);
  }

  public String getColorName() { return this.colorName; }

  public void setColorName(String colorName) {
      this.colorName = colorName;
  }
}
