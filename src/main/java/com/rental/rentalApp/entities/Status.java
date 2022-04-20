package com.rental.rentalApp.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StatusID;

    @Column(name = "Status")
    private String status;

    @Override
    public String toString() {
        return String.format("Status [ id = %d, status = %s]",
                StatusID,status);
    }
}
