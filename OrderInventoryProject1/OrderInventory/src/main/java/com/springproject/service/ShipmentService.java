package com.springproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.entity.Inventory;
import com.springproject.entity.Shipment;
import com.springproject.repository.IInventoryRepository;
import com.springproject.repository.IShipmentRepository;

@Service
public class ShipmentService {
	@Autowired
    private IShipmentRepository shipmentRepository;

    @Autowired
    private IInventoryRepository inventoryRepository;

    public Map<String, Long> getShipmentStatusWiseProductCount() {
        List<Shipment> shipments = shipmentRepository.findAll(); 
        Map<String, Long> shipmentStatusCount = new HashMap<>();

        for (Shipment shipment : shipments) {
            String shipmentStatus = shipment.getShipmentStatus();

            
            List<Inventory> inventories = inventoryRepository.findAll(); 

            long totalProductsSold = 0;
            for (Inventory inventory : inventories) {
                if (inventory.getStores().equals(shipment.getStores())) {
                    totalProductsSold += inventory.getProductInventory();
                }
            }

            
            shipmentStatusCount.put(shipmentStatus, shipmentStatusCount.getOrDefault(shipmentStatus, 0L) + totalProductsSold);
        }

        return shipmentStatusCount;
    }

}
