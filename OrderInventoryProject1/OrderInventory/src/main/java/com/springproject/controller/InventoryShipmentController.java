package com.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.entity.Inventory;
import com.springproject.service.InventoryShipmentService;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryShipmentController {
	@Autowired
    private InventoryShipmentService inventoryShipmentService;

    @GetMapping("/shipment")
    public ResponseEntity<List<Inventory>> getInventoriesForShipments(@RequestParam(required = false) Integer storeId) {
    	 if (storeId == null) {
    	        // Handle the case where storeId is not provided, e.g., return all inventories or an error
    	        return ResponseEntity.status(400).body(null);  // Return Bad Request
    	    }
    	
    	List<Inventory> inventories = inventoryShipmentService.getInventoriesMatchingShipments(storeId);

        if (inventories.isEmpty()) {
            return ResponseEntity.status(404).body(null);  
        }
        return ResponseEntity.ok(inventories);  
    }
    
    

}
