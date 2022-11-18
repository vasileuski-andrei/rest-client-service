package com.starlight.restclientservice.service;

import com.starlight.restclientservice.dto.ClientDto;
import com.starlight.restclientservice.model.Client;
import com.starlight.restclientservice.repository.ClientRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class ClientServiceTest {

    private static final String TEST_FIRST_NAME = "Test";
    private static final String TEST_LAST_NAME = "Client";
    private static final String TEST_EMAIL = "client@test.com";
    private static final String TEST_BIRTH_DATE = "1987-03-24";

    @Autowired
    private static ClientDto clientDto;

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;
    @Mock
    private ModelMapper modelMapper;

    @BeforeAll
    static void init() {
        clientDto = ClientDto.builder()
                .firstName(TEST_FIRST_NAME)
                .lastName(TEST_LAST_NAME)
                .email(TEST_EMAIL)
                .birthDate(LocalDate.parse(TEST_BIRTH_DATE))
                .build();
    }

    @Test
    void getAllClientsTest() {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client());
        doReturn(clients).when(clientRepository).findAll();

        List<Client> actual = clientService.getAll();

        assertThat(actual).isNotEmpty();
    }

    @Test
    void createNewClientTest() {
        doReturn(new Client()).when(clientRepository).save(any(Client.class));
        doReturn(new Client()).when(modelMapper).map(clientDto, Client.class);

        Client actual = clientService.create(clientDto);

        assertThat(actual).isNotNull();
    }

    @Test
    void successfullyUpdateClientTest() {
        doReturn(Optional.of(new Client())).when(clientRepository).findById(anyString());
        doReturn(new Client()).when(modelMapper).map(clientDto, Client.class);
        doReturn(new Client()).when(clientRepository).save(new Client());

        Client actual = clientService.update(clientDto);

        assertThat(actual).isNotNull();
    }

}