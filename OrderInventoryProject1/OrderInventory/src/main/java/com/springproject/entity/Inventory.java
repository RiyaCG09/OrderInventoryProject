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
@Table(name = "inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
   

	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "inventory_id")
	    private int inventoryId;
	 
	    @ManyToOne
	    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false)
	    private Stores stores;  

	    @ManyToOne
	    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
	    private Product product; 

	    @Column(name = "product_inventory", nullable = false)
	    private Integer productInventory;


	 
}

