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
    public String updateStatus(int statusID , String status){;
        statusRepository.findById(statusID).setStatus(status);
        statusRepository.save(statusRepository.findById(statusID));
        return statusRepository.findById(statusID).getStatus() ;
    }
    public Status getStatusByStatus(String status){
        return statusRepository.findByStatus(status);
    }
}

