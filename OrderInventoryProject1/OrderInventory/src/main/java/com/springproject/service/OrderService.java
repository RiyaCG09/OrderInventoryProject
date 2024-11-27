package com.springproject.service;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springproject.dto.OrderDetailsResponse;
import com.springproject.entity.Customer;

import com.springproject.entity.Order;
import com.springproject.entity.Product;

import com.springproject.entity.Stores;
import com.springproject.repository.ICustomerRepository;
import com.springproject.repository.IOrderRepository;
import com.springproject.repository.IStoreRepository;

@Service
public class OrderService {
	@Autowired
    private IOrderRepository orderRepository;
	
	 @Autowired
	    private ICustomerRepository customerRepository;
	 
	 @Autowired
	    private IStoreRepository storeRepository;
	

    public OrderDetailsResponse getOrderDetails(int orderId) {
       
        Optional<Order> orderOptional = orderRepository.findById(orderId);

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();

            
            Customer customer = order.getCustomer();
            Stores stores = order.getStores();
            
            
            Product product = null;
            
            if (order.getOrderStatus() != null) {
                product = order.getStores().getStoreId() == 1 ? new Product(1, "Sample Product", 100.0, "Red", "BrandX", "M", 5) : null;
            }

            return new OrderDetailsResponse(product, customer, stores);
        } else {
          
            return null;
        }
    }
    
    public String createOrder(Order order) {

      
        Optional<Customer> customerOpt = customerRepository.findById(order.getCustomer().getCustomerId());
        Optional<Stores> storeOpt = storeRepository.findById(order.getStores().getStoreId());

        
        if (!customerOpt.isPresent() || !storeOpt.isPresent()) {
            return "Invalid request. Please provide valid order data for creation.";
        }

        
        if (order.getOrderStatus() == null || order.getOrderStatus().isEmpty()) {
            return "Invalid request. Please provide valid order data for creation.";
        }

        
        order.setOrderTms(new Timestamp(System.currentTimeMillis()));

        
        orderRepository.save(order);

        return "Record Created Successfully";
    }
	
  
}
