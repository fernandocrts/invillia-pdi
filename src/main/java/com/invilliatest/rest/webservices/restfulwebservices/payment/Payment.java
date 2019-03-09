package com.invilliatest.rest.webservices.restfulwebservices.payment;

import java.util.Date;

public class Payment {
	
	private Integer id;
	
	private String status;
	
	private String creditcardNumber;
	
	private Date paymentDate;
	
	protected Payment() {
		
	}
	
	public Payment(Integer id, String status, String creditcardNumber, Date paymentDate) {
		super();
		this.id = id;
		this.status = status;
		this.creditcardNumber = creditcardNumber;
		this.paymentDate = paymentDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreditcardNumber() {
		return creditcardNumber;
	}

	public void setCreditcardNumber(String creditcardNumber) {
		this.creditcardNumber = creditcardNumber;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", status=" + status + ", creditcardNumber=" + creditcardNumber + ", paymentDate="
				+ paymentDate + "]";
	}
	
	
}
