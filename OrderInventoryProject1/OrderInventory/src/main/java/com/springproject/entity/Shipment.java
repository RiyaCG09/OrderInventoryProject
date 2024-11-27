package com.springproject.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shipments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "shipment_id")
	    private int shipmentId;
	 	
	    @ManyToOne
	    @JoinColumn(name = "store_id", nullable = false)
	    private Stores stores;  // Foreign key to the Store entity
	    
	    @ManyToOne
	    @JoinColumn(name = "customer_id", nullable = false)
	    private Customer customer;  // Foreign key to the Customer entity
	    
	    @Column(name = "delivery_address", length = 512, nullable = false)
	    private String deliveryAddress;
	    
	    @Column(name = "shipment_status", length = 100, nullable = false)
	    private String shipmentStatus;
	   	  
	    
	   
}
