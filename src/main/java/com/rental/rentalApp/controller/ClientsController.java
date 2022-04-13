package com.rental.rentalApp.controller;

import java.util.*;

import com.rental.rentalApp.entities.Client;
import com.rental.rentalApp.repositories.ClientRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class ClientsController {
	private final ClientRepository clients;

	private ClientsController(ClientRepository clients) {
		this.clients = clients;
	}

	@GetMapping("")
	public ResponseEntity<Iterable<Client>> getAllClients(@RequestParam Optional<String> name) {
		if (name.isPresent()) {
			return ResponseEntity.ok(clients.findByName(name.get()));
		}

		return ResponseEntity.ok(clients.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Client> getClient(@PathVariable Integer id) {
		Optional<Client> opt = clients.findById(id);

		if (opt.isPresent()) {
			return ResponseEntity.ok(opt.get());
		}

		return ResponseEntity.notFound().build();
	}
}
