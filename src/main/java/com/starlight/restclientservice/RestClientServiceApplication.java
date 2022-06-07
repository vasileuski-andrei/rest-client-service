package com.starlight.restclientservice;

import com.starlight.restclientservice.model.Client;
import com.starlight.restclientservice.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientServiceApplication.class, args);
	}

}
