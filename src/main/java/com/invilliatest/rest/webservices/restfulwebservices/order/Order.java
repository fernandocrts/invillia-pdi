package com.invilliatest.rest.webservices.restfulwebservices.order;

import java.util.Date;
import java.util.List;

import com.invilliatest.rest.webservices.restfulwebservices.orderItem.OrderItem;
import com.invilliatest.rest.webservices.restfulwebservices.payment.Payment;

public class Order {
	private int id;
	private Date confirmationDate;
	private String status;
	List<OrderItem> orderItem;
	private Payment payment;
	
	public Order() {
		
	}
	
	public Order(int id, Date confirmationDate, String status, List<OrderItem> orderItem, Payment payment) {
		super();
		this.id = id;
		this.confirmationDate = confirmationDate;
		this.status = status;
		this.orderItem = orderItem;
		this.payment = payment;
	}

	public int getId() {
		return id;
	}
	
	public Date getConfirmationDate() {
		return confirmationDate;
	}

	public String getStatus() {
		return status;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public Payment getPayment() {
		return payment;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", confirmationDate=" + confirmationDate + ", status=" + status + ", orderItem="
				+ orderItem + ", payment=" + payment + "]";
	}
	
}
