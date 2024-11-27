package com.springproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
       
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name", nullable = false, length = 255)
    private String productName;

    @Column(name = "unit_price", nullable = false)
    private double unitPrice;

    @Column(name = "colour", nullable = false, length = 45)
    private String colour;

    @Column(name = "brand",nullable = false, length = 45)
    private String brand;

    @Column(name = "size",nullable = false, length = 10)
    private String size;

    @Column(name = "rating")
    private int rating;
    

}
