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
@Data
@Table(name = "order_items")
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "line_item_id", nullable= false)
	private int lineItemId;
	
	@Column(name = "product_id", nullable= false)
	private int productId;
	
	@Column(name = "unit_price", nullable= false)
	private float unitPrice;
	
	@Column(name = "quantity", nullable= false)
	private int quantity;
	
	@Column(name = "shipment_id", nullable= false)
	private int shipmentId;
	
	
}