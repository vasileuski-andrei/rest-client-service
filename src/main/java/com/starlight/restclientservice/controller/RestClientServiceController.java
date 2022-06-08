package com.starlight.restclientservice.controller;

import com.starlight.restclientservice.dto.ClientDto;
import com.starlight.restclientservice.model.Client;
import com.starlight.restclientservice.service.ClientService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class RestClientServiceController {

    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientService.getAll();
    }

    @PostMapping("/add-client")
    public Client addClient(@RequestBody @Validated ClientDto clientDto) {
        return clientService.create(clientDto);
    }

    @DeleteMapping("/delete-client/{id}")
    public void deleteClientById(@PathVariable("id") String id) {
        clientService.delete(id);

    }

    @PutMapping("/update-client/{id}")
    public Client updateClient(@PathVariable("id") String id, @RequestBody @Validated ClientDto clientDto) {
        return clientService.update(id, clientDto);
    }

}



