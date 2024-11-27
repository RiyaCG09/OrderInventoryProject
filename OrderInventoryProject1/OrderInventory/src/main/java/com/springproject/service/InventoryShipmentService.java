package com.springproject.service;

import com.springproject.entity.Inventory;
import com.springproject.entity.Shipment;
import com.springproject.repository.IInventoryRepository;
import com.springproject.repository.IShipmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InventoryShipmentService {

    @Autowired
    private IInventoryRepository inventoryRepository;

    @Autowired
    private IShipmentRepository shipmentRepository;

    public List<Inventory> getInventoriesMatchingShipments(int storeId) {
        
        List<Shipment> shipments = shipmentRepository.findByStores_StoreId(storeId);
        
        
        if (shipments.isEmpty()) {
            return List.of();
        }

        
        List<Inventory> inventories = inventoryRepository.findByStores_StoreId(storeId);
        return inventories;
    }
    
    
}
