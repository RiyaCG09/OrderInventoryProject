package com.springproject.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.springproject.entity.Customer;
import com.springproject.repository.ICustomerRepository;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @MockitoBean
    private ICustomerRepository customerRepository; 

    @Test
    void testCreateCustomer_ValidCustomer() {
        
        Customer customer = new Customer();
        customer.setEmailAddress("test@example.com");
        customer.setFullName("John Doe");

        when(customerRepository.existsByEmailAddress(customer.getEmailAddress())).thenReturn(false);
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        
        String result = customerService.createCustomer(customer);

        
        assertEquals("Record Created Successfully", result);
    }

    @Test
    void testCreateCustomer_InvalidCustomer_MissingEmail() {
        
        Customer customer = new Customer();
        customer.setFullName("John Doe");

        
        String result = customerService.createCustomer(customer);

        
        assertEquals("Invalid request. Please provide valid customer data.", result);
    }

    @Test
    void testCreateCustomer_InvalidCustomer_MissingFullName() {
        
        Customer customer = new Customer();
        customer.setEmailAddress("test@example.com");

     
        String result = customerService.createCustomer(customer);

        
        assertEquals("Invalid request. Please provide valid customer data.", result);
    }

    @Test
    void testCreateCustomer_EmailAlreadyExists() {
        
        Customer customer = new Customer();
        customer.setEmailAddress("test@example.com");
        customer.setFullName("John Doe");

        when(customerRepository.existsByEmailAddress(customer.getEmailAddress())).thenReturn(true);

        
        String result = customerService.createCustomer(customer);

        
        assertEquals("Customer with this email address already exists.", result);
    }
}
