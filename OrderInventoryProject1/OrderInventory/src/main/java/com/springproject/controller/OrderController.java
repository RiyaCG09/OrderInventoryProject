package com.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springproject.dto.OrderDetailsResponse;
import com.springproject.entity.Order;
import com.springproject.service.OrderService;

@RestController
@RequestMapping("/api/v1/inventory")
public class OrderController {
	 @Autowired
	    private OrderService orderService;

	    @GetMapping("/inventory/{orderid}")
	    public ResponseEntity<OrderDetailsResponse> getOrderDetails(@PathVariable Integer orderid) {
	        
	        OrderDetailsResponse orderDetails = orderService.getOrderDetails(orderid);
	        
	        if (orderDetails != null) {
	            return ResponseEntity.ok(orderDetails);
	        } else {
	            
	            return ResponseEntity.status(404).body(null);
	        }
	    }
	    
	    @PostMapping("/orders")
	    public ResponseEntity<String> createOrder(@RequestBody Order order) {
	        
	    	return ResponseEntity.ok("Record created successfully");
	       
	    }
	  
	    
	    
	

}
