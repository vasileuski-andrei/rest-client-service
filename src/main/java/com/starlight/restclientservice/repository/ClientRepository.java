package com.starlight.restclientservice.repository;

import com.starlight.restclientservice.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

    void deleteClientById(String id);

}
