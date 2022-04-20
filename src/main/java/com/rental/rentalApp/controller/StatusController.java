package com.rental.rentalApp.controller;

import com.rental.rentalApp.entities.Status;
import com.rental.rentalApp.services.StatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rental-app/api/status")
public class StatusController {
    private StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("{statusID}/{status}/update-status")
    public String updateStatus(@PathVariable Integer statusID, @PathVariable String status){
        return statusService.updateStatus(statusID,status);
    }

    @GetMapping("{status}/get-status")
    public Status getStatus(@PathVariable String status){
        return statusService.getStatusByStatus(status);
    }
}
