package com.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

	boolean existsByEmailAddress(String emailAddress);

}
