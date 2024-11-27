package com.springproject.dto;

import com.springproject.entity.Customer;
import com.springproject.entity.Product;
import com.springproject.entity.Stores;

public class OrderDetailsResponse {
	private Product product;
    private Customer customer;
    private Stores stores;

    
    public OrderDetailsResponse(Product product, Customer customer, Stores stores) {
        this.product = product;
        this.customer = customer;
        this.stores = stores;
    }

    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Stores getStore() {
        return stores;
    }

    public void setStore(Stores store) {
        this.stores = store;
    }

}
