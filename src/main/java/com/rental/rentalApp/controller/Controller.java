package com.rental.rentalApp.controller;
import com.rental.rentalApp.entities.Client;
import com.rental.rentalApp.repositories.ClientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {
    private final ClientRepository clients;
    private
    Controller(ClientRepository clients) {
        this.clients = clients;
    }

    @GetMapping("rental-app/clients")
    Iterable<Client> getAllClients() {
        return clients.findAll();
    }

    @GetMapping("rental-app/home")
    public String Home() {
        return "Welcome to Car Rental App!";
    }
}