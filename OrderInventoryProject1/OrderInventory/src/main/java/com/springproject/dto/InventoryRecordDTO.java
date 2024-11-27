package com.springproject.dto;

public class InventoryRecordDTO {
	
	 private Integer inventoryId;
	    private Integer storeId;
	    private Integer productId;
	    private Integer productInventory;
	    private String productName;
	    private double unitPrice;
	    
	    
	    public InventoryRecordDTO(Integer inventoryId, Integer storeId, Integer productId, 
	                              Integer productInventory, String productName, double d ) {
	        this.inventoryId = inventoryId;
	        this.storeId = storeId;
	        this.productId = productId;
	        this.productInventory = productInventory;
	        this.productName = productName;
	        this.unitPrice = d;
	        
	        
	    }

	    public Integer getInventoryId() {
	        return inventoryId;
	    }

	    public void setInventoryId(Integer inventoryId) {
	        this.inventoryId = inventoryId;
	    }

	    public Integer getStoreId() {
	        return storeId;
	    }

	    public void setStoreId(Integer storeId) {
	        this.storeId = storeId;
	    }

	    public Integer getProductId() {
	        return productId;
	    }

	    public void setProductId(Integer productId) {
	        this.productId = productId;
	    }

	    public Integer getProductInventory() {
	        return productInventory;
	    }

	    public void setProductInventory(Integer productInventory) {
	        this.productInventory = productInventory;
	    }

	    public String getProductName() {
	        return productName;
	    }

	    public void setProductName(String productName) {
	        this.productName = productName;
	    }

	    public double getUnitPrice() {
	        return unitPrice;
	    }

	    public void setUnitPrice(double unitPrice) {
	        this.unitPrice = unitPrice;
	    }

}
