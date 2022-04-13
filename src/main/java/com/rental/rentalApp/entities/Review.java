package com.rental.rentalApp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Column;

import java.time.LocalDateTime; 

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ReviewID")
    private Long id;

    @Column(name = "Rating")
    private int rating;

    @Column(name = "Message")
    private String message;

    @Column(name = "Date")
    private LocalDateTime date;

    protected Review(){}

    Review(LocalDateTime date, String message, int rating){
        this.date = date;
        this.message = message;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review [ id = "+id+", rating = "+rating+", message = "+message+", date="+date+" ]";
    }

    // Accessors
    public int getRating() { return this.rating; }
    public String getMessage() { return this.message; }
    public LocalDateTime getDate() { return this.date; }

    // Mutators
    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
}
