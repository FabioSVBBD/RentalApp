package com.rental.rentalApp.controller;

import com.rental.rentalApp.entities.*;
import com.rental.rentalApp.services.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentalController {

    private final StatusService statusService;

    public RentalController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("rental-app/update-status/{statusID}/{status}")
    public String updateStatus(@PathVariable Integer statusID, @PathVariable String status){
        return statusService.updateStatus(statusID,status);
    }
    @GetMapping("rental-app/get-status/{status}")
    public List<Status> getStatus(@PathVariable String status){
        return statusService.getStatusByStatus(status);
    }

}
