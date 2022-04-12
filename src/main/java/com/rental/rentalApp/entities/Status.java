package com.rental.rentalApp.entities;

import javax.persistence.*;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int StatusID;

    @Column(name = "Status")
    private String status;

    public Status() {
    }

    public Status(String status) {

        this.status = status;
    }
    public int getStatusID() {
        return StatusID;
    }

    public void setStatusID(int statusID) {
        StatusID = statusID;
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
