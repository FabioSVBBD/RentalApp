package com.rental.rentalApp.entities;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Rental {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int RentalID;
	 
	 @Column(name = "Address")
	  private String address;
	 
	 @Column(name = "ClientID")
	  private int clientID;
	 
	 @Column(name = "VehicleID")
	  private int vehicleID;
	 
	 @Column(name = "PaymentMethodID")
	  private int paymentMethodID;
	 
	 @Column(name = "StatusID")
	  private int statusID;
	 
	 @Column(name = "ReviewID")
	  private int reviewID;
	 
	 @Column(name = "StartDate")
	  private Date startDate;
	 
	 
	 @Column(name = "EndDate")
	  private Date endDate;
	 
	 @Column(name = "Balance")
	  private Double balance;
	 
	 
	 public Rental() {}
	 
	 public Rental(String address, int clientId, int vehicleId, int paymentMethodId, int statusId, int reviewId, Date startDate, Date endDate, double balance) {
	        this.setAddress(address);
	        this.setClient(clientId);
	        this.setVehicle(vehicleId);
	        this.setAPaymentMethod(paymentMethodId);
	        this.setStatus(statusId);
	        this.setStartDate(startDate);
	        this.setEndDate(endDate);
	        this.setBalance(balance);
	 }
	 
	 @Override
	    public String toString() {
		 	return "Rental [ ID = " + RentalID + ", Address = " + address  + ", Client = " +  clientID  + ", Vehicle = " +  vehicleID  + ", PaymentMethod = " +  paymentMethodID + ", Status = " +  statusID  + ", Review = " +  reviewID  + ", StartDate = " +  startDate  + ", EndDate = " +  endDate  + ", Balance = " +  balance + " ]";
	    }
	 
	 public String getAddress() { return this.address; }
	 public int getClient() { return this.clientID; }
	 public int getVehicle() { return this.vehicleID; }
	 public int getPaymentMethod() { return this.paymentMethodID; }
	 public int getStatus() { return this.statusID; }
	 public int getReview() { return this.reviewID; }
	 public Date getStartDate() { return this.startDate; }
	 public Date getEndDate() { return this.endDate; }
	 public Double getBalance() { return this.balance; }
	 
	 public void setAddress(String address) {
	        this.address = address;
	 }
	 
	 public void setClient(int clientId) {
	        this.clientID = clientId;
	 }
	 
	 public void setVehicle(int vehicleId) {
	        this.vehicleID = vehicleId;
	 }
	 
	 public void setAPaymentMethod(int paymentMethodId) {
	        this.paymentMethodID = paymentMethodId ;
	 }
	 
	 public void setStatus(int statusId) {
	        this.statusID = statusId; 
	 }
	 
	 public void setReview(int reviewId) {
	        this.reviewID = reviewId ;
	 }
	 
	 public void setStartDate(Date startDate) {
	        this.startDate = startDate ; 
	 }
	 
	 public void setEndDate(Date endDate) {
	        this.endDate = endDate;
	 }
	 
	 public void setBalance(Double balance) {
	        this.balance = balance ; 
	 }
}
