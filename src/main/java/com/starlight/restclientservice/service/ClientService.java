package com.starlight.restclientservice.service;

import com.starlight.restclientservice.model.Client;
import com.starlight.restclientservice.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientService implements CommonService<Client, String>{

    ClientRepository clientRepository;

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public void create(Client client) {
        client.setCreationDate(LocalDateTime.now());
        clientRepository.save(client);
    }

    @Override
    public void delete(String id) {
        clientRepository.deleteClientById(id);
    }

    @Override
    public Client update(String id, Client client) {
        return null;
    }

}
