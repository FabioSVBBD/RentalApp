package com.rental.rentalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rental-app/api/")
public class Controller {
  @GetMapping("home")
    public String Home() {
      return "Welcome to Car Rental App!";
    }
}
