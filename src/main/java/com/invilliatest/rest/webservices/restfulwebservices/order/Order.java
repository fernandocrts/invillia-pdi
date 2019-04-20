package com.invilliatest.rest.webservices.restfulwebservices.order;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.invilliatest.rest.webservices.restfulwebservices.orderItem.OrderItem;
import com.invilliatest.rest.webservices.restfulwebservices.payment.Payment;

@Entity
@Table(name = "order_table")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private Date confirmationDate;
	private String status;
	
	/*
	 * @OneToMany(mappedBy = "order") List<OrderItem> orderItem;
	 */
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
	private Payment payment;
	
	/*
	 * @OneToOne( fetch = FetchType.LAZY, optional = false )
	 * 
	 * @JoinColumn(name = "id") private Store store;
	 */
	
	public Order() {
		
	}
	
	public Order(int id, Date confirmationDate, String status, List<OrderItem> orderItem, Payment payment) {
		super();
		this.id = id;
		this.confirmationDate = confirmationDate;
		this.status = status;
		//this.orderItem = orderItem;
		this.payment = payment;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/*
	 * public Store getStore() { return store; }
	 * 
	 * public void setStore(Store store) { this.store = store; }
	 */
	public int getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}


	public Date getConfirmationDate() {
		return confirmationDate;
	}
	
	public void setConfirmationDate(Date confirmationDate) {
		this.confirmationDate = confirmationDate;
	}


	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	/*
	 * public List<OrderItem> getOrderItem() { return orderItem; }
	 * 
	 * public void setOrderItem(List<OrderItem> orderItem) { this.orderItem =
	 * orderItem; }
	 */

	/*
	 * @Override public String toString() { return "Order [id=" + id +
	 * ", confirmationDate=" + confirmationDate + ", status=" + status +
	 * ", orderItem=" + orderItem + ", payment=" + payment + "]"; }
	 */
	
}
