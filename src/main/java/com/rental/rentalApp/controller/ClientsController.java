package com.rental.rentalApp.controller;

import com.rental.rentalApp.constants.AccessTokens;
import com.rental.rentalApp.entities.Client;
import com.rental.rentalApp.repositories.ClientRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rental-app/api/clients")
public class ClientsController {
	private final ClientRepository clients;

	private ClientsController(ClientRepository clients) {
		this.clients = clients;
	}

	@GetMapping("")
	public ResponseEntity<Iterable<Client>> getAllClients(
			@RequestParam(required = false) String name, @RequestParam(required = false) String surname,
			@RequestParam(required = false) String email, @RequestParam(required = false) String number) {
		if (name != null) {
			return ResponseEntity.ok(clients.findByName(name));
		}

		if (surname != null) {
			return ResponseEntity.ok(clients.findBySurname(surname));
		}

		if (email != null) {
			return ResponseEntity.ok(clients.findByEmail(email));
		}

		if (number != null) {
			return ResponseEntity.ok(clients.findByNumber(number));
		}

		return ResponseEntity.ok(clients.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Client> getClient(@PathVariable Integer id) {
		Client client = clients.findById(id).get();

		if (client != null) {
			return ResponseEntity.ok(client);
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping("")
	public ResponseEntity<String> postClient(@RequestBody Client client) {
		if (client == null) {
			return ResponseEntity.badRequest().build();
		}

		clients.save(client);

		return ResponseEntity.ok(String.format("%s %s saved successfully", client.getName(), client.getSurname()));
	}

	@PatchMapping("{id}")
	public ResponseEntity<String> patchClient(@PathVariable Integer id, @RequestBody Client updateData) {
		StringBuilder response = new StringBuilder();

		Client client = clients.findById(id).get();

		if (client == null) {
			return ResponseEntity.badRequest().build();
		}

		if (updateData.getName() != null) {
			client.setName(updateData.getName());
			response.append(String.format("Name Updated: %s\n", updateData.getName()));
		}

		if (updateData.getSurname() != null) {
			client.setSurname(updateData.getSurname());
			response.append(String.format("Surname Updated: %s\n", updateData.getSurname()));
		}

		if (updateData.getEmail() != null) {
			client.setEmail(updateData.getEmail());
			response.append(String.format("E-mail Updated: %s\n", updateData.getEmail()));
		}

		if (updateData.getNumber() != null) {
			client.setNumber(updateData.getNumber());
			response.append(String.format("Number Updated: %s\n", updateData.getNumber()));
		}

		clients.save(updateData);

		return ResponseEntity.ok(response.toString());
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteClient(@PathVariable Integer id, @RequestParam String token) {
		if (token != null && token.equals(AccessTokens.getSecurityKey())) {
			Client client = clients.findById(id).get();
			clients.deleteById(id);

			return ResponseEntity.ok(String.format("Deleted %s %s Successfully", client.getName(), client.getSurname()));
		}

		return ResponseEntity.badRequest().build();
	}
}
