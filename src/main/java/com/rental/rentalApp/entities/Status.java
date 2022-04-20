package com.rental.rentalApp.entities;

import javax.persistence.*;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StatusID;

    @Column(name = "Status")
    private String status;

    public Status() {
    }

    public Status(String status) {
        this.setStatus(status);
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Status [ id = %d, status = %s]",
                StatusID,status);
    }

}
