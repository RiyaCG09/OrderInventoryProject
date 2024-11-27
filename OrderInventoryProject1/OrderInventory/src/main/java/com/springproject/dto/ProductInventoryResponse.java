package com.springproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInventoryResponse {
	 private int productId;
	    private String productName;
	    private String brand; 
	    private int inventoryQuantity;

}
