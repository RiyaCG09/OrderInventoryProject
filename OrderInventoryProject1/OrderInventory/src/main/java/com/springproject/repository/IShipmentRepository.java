package com.springproject.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springproject.entity.Shipment;

@Repository
public interface IShipmentRepository extends JpaRepository<Shipment, Integer> {
	
	List<Shipment> findByStores_StoreId(int storeId);
	 List<Shipment> findByStores_StoreIdAndShipmentStatus(int storeId, String shipmentStatus);
	 
	
	
}
