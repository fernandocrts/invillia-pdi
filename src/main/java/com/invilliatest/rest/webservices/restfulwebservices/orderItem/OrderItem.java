package com.invilliatest.rest.webservices.restfulwebservices.orderItem;

public class OrderItem {
	private int id;
	private String description;
	private double price;
	private Integer quantity;
	
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
