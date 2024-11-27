package com.springproject.entity;

import java.sql.Timestamp;

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
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
     
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_tms", nullable = false)
    private Timestamp orderTms;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;  

    @Column(name = "order_status",length=10, nullable = false)
    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Stores stores; 
    
    
    
    

}
