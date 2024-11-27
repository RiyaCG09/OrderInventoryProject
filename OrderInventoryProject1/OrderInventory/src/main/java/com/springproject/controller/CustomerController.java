package com.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.entity.Customer;
import com.springproject.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	@Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
    	
    		customerService.createCustomer(customer);
    	
    	return ResponseEntity.ok("Customer created successfully");
    	
        

    }
}
