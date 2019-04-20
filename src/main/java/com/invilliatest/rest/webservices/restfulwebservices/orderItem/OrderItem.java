package com.invilliatest.rest.webservices.restfulwebservices.orderItem;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.invilliatest.rest.webservices.restfulwebservices.order.Order;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String description;
	private double price;
	private Integer quantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Order order;
	
	public OrderItem() {
		
	}
	
	public OrderItem(int id, String description, double price, int quantity) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", description=" + description + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}

}
