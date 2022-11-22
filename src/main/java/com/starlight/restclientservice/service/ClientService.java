package com.starlight.restclientservice.service;

import com.starlight.restclientservice.dto.ClientDto;
import com.starlight.restclientservice.model.Client;
import com.starlight.restclientservice.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientService implements CommonService<Client, ClientDto> {

    private final ModelMapper modelMapper;
    private final ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client create(ClientDto clientDto) {
        clientDto.setCreationDate(LocalDateTime.now());
        Client client = convertToClient(clientDto);
        return clientRepository.save(client);
    }

    public void deleteById(String id) {
        clientRepository.deleteById(id);
    }

    public Client update(ClientDto clientDto) {
        Client updatedClient = null;
        Optional<Client> clientById = clientRepository.findById(clientDto.getId());

        if (clientById.isPresent()) {
            clientDto.setCreationDate(clientById.get().getCreationDate());
            Client client = convertToClient(clientDto);
            updatedClient = clientRepository.save(client);
        }

        return updatedClient;
    }

    private Client convertToClient(ClientDto userDto) {
        return modelMapper.map(userDto, Client.class);
    }

}
