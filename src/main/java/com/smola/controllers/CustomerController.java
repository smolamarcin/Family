package com.smola.controllers;

import com.smola.model.Customer;
import com.smola.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping(value = "/customers")
    ResponseEntity<Iterable<Customer>> getALlCustomers(){
        return ResponseEntity.ok().body(customerRepository.findAll());
    }

}
