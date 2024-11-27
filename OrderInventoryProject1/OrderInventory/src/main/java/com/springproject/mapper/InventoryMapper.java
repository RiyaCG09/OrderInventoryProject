package com.springproject.mapper;

import org.springframework.stereotype.Component;

import com.springproject.dto.InventoryRecordDTO;
import com.springproject.entity.Inventory;

@Component
public class InventoryMapper {
	
	 public InventoryRecordDTO toInventoryRecordDTO(Inventory inventory) {
	        
	        return new InventoryRecordDTO(
	            inventory.getInventoryId(),
	            inventory.getStores().getStoreId(),
	            inventory.getProduct().getProductId(),
	            inventory.getProductInventory(),
	            inventory.getProduct().getProductName(),
	            inventory.getProduct().getUnitPrice()
	        );
	    }

}
