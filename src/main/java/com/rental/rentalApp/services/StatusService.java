package com.rental.rentalApp.services;

import com.rental.rentalApp.entities.Status;
import com.rental.rentalApp.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }
    public String updateStatus(int statusID , String status){

        return "Status changed from "+""+" to "+status;
    }
}

