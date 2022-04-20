package com.rental.rentalApp.entities;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity
@DynamicUpdate
@DynamicInsert
@Data
public class Rental {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int rentalID;
	 
	 @Column(name = "Address")
	 private String address;

	 @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	 @JoinColumn(name = "ClientID", nullable = false)
	 private Client client;

	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "EmployeeID", nullable = false)
	private Employee employee;

	 @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	 @JoinColumn(name = "VehicleID", nullable = false)
	 private Vehicle vehicle;
	 
	 @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	 @JoinColumn(name = "PaymentMethodID", nullable = false)
	 private PaymentMethod paymentMethod;
	 
	 @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	 @JoinColumn(name = "StatusID", nullable = false)
	 private Status status;
	 
	 @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	 @JoinColumn(name = "ReviewID", nullable = true)
	 private Review review;
	 
	 @Column(name = "StartDate")
	 private Date startDate;

	 @Column(name = "EndDate")
	 private Date endDate;
	 
	 @Column(name = "Balance")
	 private BigDecimal balance;

	@Override
	    public String toString() {
		 	return "Rental [ ID = " + rentalID + ", Address = " + address  + ", Client = " +  client  + ", Vehicle = " +  vehicle  + ", PaymentMethod = " +  paymentMethod + ", Status = " +  status  + ", Review = " +  review  + ", StartDate = " +  startDate  + ", EndDate = " +  endDate  + ", Balance = " +  balance + " ]";
	    }


}