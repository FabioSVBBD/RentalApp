package com.rental.rentalApp.controller;

import com.rental.rentalApp.entities.Status;
import com.rental.rentalApp.services.StatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    private StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("rental-app/update-status/{statusID}/{status}")
    public String updateStatus(@PathVariable Integer statusID, @PathVariable String status){
        return statusService.updateStatus(statusID,status);
    }
    @GetMapping("rental-app/get-status/{status}")
    public Status getStatus(@PathVariable String status){
        return statusService.getStatusByStatus(status);
    }
}
