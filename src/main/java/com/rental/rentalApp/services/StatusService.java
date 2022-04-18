package com.rental.rentalApp.services;

import com.rental.rentalApp.entities.Status;
import com.rental.rentalApp.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }
    public String updateStatus(int statusID , String status){
        String previousStatus = statusRepository.findById(statusID).getStatus();
        statusRepository.findById(statusID).setStatus(status);
        statusRepository.save(statusRepository.findById(statusID));
        return "Status changed from "+previousStatus+" to "+status;
    }
    public Status getStatusByStatus(String status){
        return statusRepository.findByStatus(status);
    }
}

