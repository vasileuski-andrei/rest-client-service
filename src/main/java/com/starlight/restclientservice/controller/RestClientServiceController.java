package com.starlight.restclientservice.controller;

import com.starlight.restclientservice.model.Client;
import com.starlight.restclientservice.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class RestClientServiceController {

    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        List<Client> clients = clientService.getAll();
        return clients;
    }

    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client client) {
        clientService.create(client);
        return client;
    }

    @DeleteMapping("/delete-client/{id}")
    public void deleteClientById(@PathVariable("id") String id) {
        clientService.delete(id);

    }

    @PutMapping("/update-client/{id}")
    public Client updateClient(@PathVariable("id") String id, @RequestBody Client client) {
        clientService.update(id, client);
        return client;
    }

    }



