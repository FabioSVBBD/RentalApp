package com.rental.rentalApp.entities;

import javax.persistence.*;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BrandID;

    @Column(name = "BrandName")
    private String brandName;

    protected Brand() { }

    public Brand(String brandName) {
      this.setBrandName(brandName);
  }

  @Override
  public String toString() {
      return String.format("Brand => ID: "+ BrandID +" BrandName: " + brandName);
  }

  public String getBrandName() { return this.brandName; }

  public void setBrandName(String brandName) {
      this.brandName = brandName;
  }
}
