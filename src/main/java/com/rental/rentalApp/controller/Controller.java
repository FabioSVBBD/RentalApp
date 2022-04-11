package com.rental.rentalApp.controller;
import com.rental.rentalApp.entities.Client;
import com.rental.rentalApp.entities.Status;
import com.rental.rentalApp.repositories.ClientRepository;
import com.rental.rentalApp.repositories.StatusRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {
    private final ClientRepository clients;
    private final StatusRepository statuses;

    private
    Controller(ClientRepository clients, StatusRepository statuses) {
        this.clients = clients;
        this.statuses = statuses;
    }

    @GetMapping("rental-app/clients")
    Iterable<Client> getAllClients() {
        return clients.findAll();
    }

    @GetMapping("rental-app/statuses")
    Iterable<Status> getAllStatuses() {
        return statuses.findAll();
    }

    @GetMapping("rental-app/home")
    public String Home() {
        return "Welcome to Car Rental App!";
    }
}