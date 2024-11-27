package com.springproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.entity.Order;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
	 
	List<Order> findByStores_StoreId(int storeId);
	Optional<Order> findByOrderId(int orderId);
}
