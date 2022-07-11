package com.academy.rest;

import com.academy.rest.repositories.CustomerRepository;
import com.academy.rest.repositories.OrderRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestHateoasApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestHateoasApplication.class,args);

	}

}
