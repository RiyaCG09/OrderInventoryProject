package com.springproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springproject.dto.InventoryData;
import com.springproject.dto.InventoryRecordDTO;


import com.springproject.dto.ProductInventoryResponse;
import com.springproject.entity.Inventory;
import com.springproject.service.InventoryService;
import com.springproject.service.ShipmentService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {
	
	 @Autowired
	    private InventoryService inventoryService;
	 
	 @Autowired
	    private ShipmentService shipmentService;

	    @GetMapping("/inventory/product/{productId}/stores/{storeId}")
	    public ResponseEntity<?> getInventory(@PathVariable Integer storeId, @PathVariable Integer productId) {
	        try {
	            
	            InventoryRecordDTO inventoryRecord = inventoryService.getInventoryByProductAndStore(productId, storeId);
	            return new ResponseEntity<>(inventoryRecord, HttpStatus.OK);
	        } catch (EntityNotFoundException e) {
	            
	            return new ResponseEntity<>("Inventory records for the specified product and store not found", HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @GetMapping("/inventory/category/{brand}")
	    public ResponseEntity<?> getInventoryByCategory(@PathVariable String brand) {
	        try {
	            List<ProductInventoryResponse> inventoryRecords = inventoryService.getInventoryByProductAttribute(brand);
	            return new ResponseEntity<>(inventoryRecords, HttpStatus.OK);
	        } catch (RuntimeException ex) {
	            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    @GetMapping("/inventory")
	    public ResponseEntity<?> getAllInventory() {
	        try {
	            List<Inventory> inventoryList = inventoryService.getAllInventory();
	            return new ResponseEntity<>(inventoryList, HttpStatus.OK);
	        } catch (Exception e) {
	            
	            return new ResponseEntity<>("An internal server error occurred while fetching all inventory records.", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	   
	    
	    @GetMapping("/inventory/")
	    public ResponseEntity<InventoryData> getInventory(@RequestParam Integer storeid) {
	        InventoryData inventoryData = inventoryService.getInventoryByStoreId(storeid);
	        if (inventoryData == null) {
	            return ResponseEntity.status(404).body(null);  
	        }
	        return ResponseEntity.ok(inventoryData);  
	    }
	    
	    @GetMapping("/shipment/")
	    public ResponseEntity<Map<String, Long>> getShipmentStatusWiseProductCount() {
	        try {
	            Map<String, Long> result = shipmentService.getShipmentStatusWiseProductCount();
	            return ResponseEntity.ok(result);
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body(null); 
	        }
	    }
	    
	   

}
