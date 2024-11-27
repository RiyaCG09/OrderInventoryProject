package com.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.entity.Customer;
import com.springproject.repository.ICustomerRepository;

@Service
public class CustomerService {
	@Autowired
    private ICustomerRepository customerRepository;

    
    public String createCustomer(Customer customer) {

        
        if (customer == null || customer.getEmailAddress() == null || customer.getEmailAddress().isEmpty() || 
            customer.getFullName() == null || customer.getFullName().isEmpty()) {
            return "Invalid request. Please provide valid customer data.";
        }

        
        if (customerRepository.existsByEmailAddress(customer.getEmailAddress())) {
            return "Customer with this email address already exists.";
        }

        
        customerRepository.save(customer);
        return "Record Created Successfully";
    }

}
