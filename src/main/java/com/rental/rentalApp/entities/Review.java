package com.rental.rentalApp.entities;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.time.LocalDateTime;

@Entity
@Data
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ReviewID")
	private Long id;

	@Column(name = "Rating")
	private int rating;

	@Column(name = "Message")
	private String message;

	@Column(name = "Date")
	private LocalDateTime date;

	@Override
	public String toString() {
		return "Review [ id = " + id + ", rating = " + rating + ", message = " + message + ", date=" + date + " ]";
	}
}
