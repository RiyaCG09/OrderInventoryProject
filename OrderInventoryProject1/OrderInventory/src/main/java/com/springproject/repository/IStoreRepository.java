package com.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.entity.Stores;

public interface IStoreRepository extends JpaRepository<Stores, Integer> {
	
}
