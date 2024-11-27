package com.springproject.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.dto.InventoryData;
import com.springproject.dto.InventoryRecordDTO;
import com.springproject.dto.ProductInventoryResponse;
import com.springproject.entity.Inventory;
import com.springproject.entity.Order;
import com.springproject.entity.Product;
import com.springproject.entity.Stores;
import com.springproject.mapper.InventoryMapper;
import com.springproject.repository.IInventoryRepository;
import com.springproject.repository.IOrderRepository;
import com.springproject.repository.IProductRepository;
import com.springproject.repository.IStoreRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InventoryService {
	    @Autowired
	    private IInventoryRepository inventoryRepository;

	    @Autowired
	    private IProductRepository productRepository;

	    @Autowired
	    private IStoreRepository storeRepository;
	    
	    @Autowired
	    private InventoryMapper inventoryMapper;
	    
	    @Autowired
	    private IOrderRepository orderRepository;
	    
	    

	    public InventoryRecordDTO getInventoryByProductAndStore(Integer productId, Integer storeId) {
	        
	    	Product product = productRepository.findById(productId)
	                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

	        Stores stores = storeRepository.findById(storeId)
	                .orElseThrow(() -> new EntityNotFoundException("Store not found"));
	        
	        Inventory inventory = inventoryRepository.findByProductAndStores(product, stores);

	        if (inventory == null) {
	            throw new EntityNotFoundException("Inventory record not found");
	        }

	        return inventoryMapper.toInventoryRecordDTO(inventory);
	    }
	    
	    public List<ProductInventoryResponse> getInventoryByProductAttribute(String brand) {
	        
	        List<Inventory> inventoryList = inventoryRepository.findAll();

	        
	        List<ProductInventoryResponse> filteredInventory = inventoryList.stream()
	                .filter(inventory -> inventory.getProduct().getBrand().equalsIgnoreCase(brand)) 
	                .map(inventory -> new ProductInventoryResponse(
	                        inventory.getProduct().getProductId(),
	                        inventory.getProduct().getProductName(),
	                        inventory.getProduct().getBrand(),
	                        inventory.getProductInventory()
	                ))
	                .collect(Collectors.toList());

	        if (filteredInventory.isEmpty()) {
	            throw new RuntimeException("Not found");
	        }

	        return filteredInventory;
	    }
	    
	    public List<Inventory> getAllInventory() {
	        return inventoryRepository.findAll();
	    }
	    
	 
	    
	    public InventoryData getInventoryByStoreId(Integer storeId) {
	        
	        List<Product> products = productRepository.findAll();
	        Stores store = storeRepository.findById(storeId).orElse(null);
	        List<Order> orders = orderRepository.findByStores_StoreId(storeId);

	        if (store != null) {
	            return new InventoryData(store, products, orders);
	        } else {
	            return null;  
	        }
	    }
	    
		
}
