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
	 
	 @ManyToOne
	 @JoinColumn(name = "ClientID", nullable = false)
	  private Client client;
	 
	 @ManyToOne
	 @JoinColumn(name = "VehicleID", nullable = false)
	  private Vehicle vehicle;
	 
	 @ManyToOne
	 @JoinColumn(name = "PaymentMethodID", nullable = false)
	  private PaymentMethod paymentMethod;
	 
	 @ManyToOne
	 @JoinColumn(name = "StatusID", nullable = false)
	  private Status status;
	 
	 @ManyToOne
	 @JoinColumn(name = "ReviewID", nullable = false)
	  private Review review;
	 
	 @Column(name = "StartDate")
	  private Date startDate;
	 
	 
	 @Column(name = "EndDate")
	  private Date endDate;
	 
	 @Column(name = "Balance")
	  private Double balance;
	 
	 
	 public Rental() {}
	 
	 public Rental(String address, Client client, Vehicle vehicle, PaymentMethod paymentMethod, Status status, Review review, Date startDate, Date endDate, double balance) {
	        this.setAddress(address);
	        this.setClient(client);
	        this.setVehicle(vehicle);
	        this.setAPaymentMethod(paymentMethod);
	        this.setStatus(status);
	        this.setStartDate(startDate);
	        this.setEndDate(endDate);
	        this.setBalance(balance);
	 }
	 
	 @Override
	    public String toString() {
		 	return "Rental [ ID = " + RentalID + ", Address = " + address  + ", Client = " +  client  + ", Vehicle = " +  vehicle  + ", PaymentMethod = " +  paymentMethod + ", Status = " +  status  + ", Review = " +  review  + ", StartDate = " +  startDate  + ", EndDate = " +  endDate  + ", Balance = " +  balance + " ]";
	    }
	 
	 public String getAddress() { return this.address; }
	 public Client getClient() { return this.client; }
	 public Vehicle getVehicle() { return this.vehicle; }
	 public PaymentMethod getPaymentMethod() { return this.paymentMethod; }
	 public Status getStatus() { return this.status; }
	 public Review getReview() { return this.review; }
	 public Date getStartDate() { return this.startDate; }
	 public Date getEndDate() { return this.endDate; }
	 public Double getBalance() { return this.balance; }
	 
	 public void setAddress(String address) {
	        this.address = address;
	 }
	 
	 public void setClient(Client client) {
	        this.client= client;
	 }
	 
	 public void setVehicle(Vehicle vehicle) {
	        this.vehicle = vehicle;
	 }
	 
	 public void setAPaymentMethod(PaymentMethod paymentMethod) {
	        this.paymentMethod = paymentMethod ;
	 }
	 
	 public void setStatus(Status status) {
	        this.status = status; 
	 }
	 
	 public void setReview(Review review) {
	        this.review = review ;
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
