package com.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springproject.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {
	
	

}
