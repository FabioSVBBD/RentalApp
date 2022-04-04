package com.rental.rentalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("rental-app/home")
    public String Home() {
        return "Welcome to Car Rental App!";
    }
}
