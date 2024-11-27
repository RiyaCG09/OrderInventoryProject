package com.springproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.entity.OrderItems;

public interface IOrderItemsRepository extends JpaRepository<OrderItems, Integer> {

	List<OrderItems> findAllByOrderId(int orderId);

	

}
