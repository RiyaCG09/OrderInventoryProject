package com.springproject.dto;

import java.util.List;

import com.springproject.entity.Order;
import com.springproject.entity.Product;
import com.springproject.entity.Stores;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryData {

    private Stores stores;
    private List<Product> products;
    private List<Order> orders;
}
