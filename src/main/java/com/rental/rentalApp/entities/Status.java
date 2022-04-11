package com.rental.rentalApp.entities;

import javax.persistence.*;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int StatusID;

    @Column(name = "Status")
    private String Status;

    public Status() {
    }

    public Status(String status) {
        Status = status;
    }
    public int getStatusID() {
        return StatusID;
    }

    public void setStatusID(int statusID) {
        StatusID = statusID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return String.format("Status [ id = %d, status = %s]",
                StatusID,Status);
    }

}
