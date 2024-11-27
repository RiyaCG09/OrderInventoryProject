package com.springproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.entity.Inventory;
import com.springproject.entity.Product;
import com.springproject.entity.Stores;

public interface IInventoryRepository extends JpaRepository<Inventory, Integer> {

	Inventory findByProductAndStores(Product product, Stores stores);
	List<Inventory> findAll();
	List<Inventory> findByStores_StoreIdAndProduct_ProductId(int storeId, int productId);
	List<Inventory> findByStores_StoreId(int storeId);
	
	
}
