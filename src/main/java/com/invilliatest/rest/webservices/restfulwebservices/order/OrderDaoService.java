package com.invilliatest.rest.webservices.restfulwebservices.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.invilliatest.rest.webservices.restfulwebservices.orderItem.OrderItem;
import com.invilliatest.rest.webservices.restfulwebservices.payment.Payment;

public class OrderDaoService {
	
	private static List<Order> orderList = new ArrayList<>();
	private static List<OrderItem> orderItems = new ArrayList<>();
	
	static{
		orderItems.add(new OrderItem(1, "feijao", 4.0, 1));
		orderItems.add(new OrderItem(2, "arroz", 3.99, 1));
		orderItems.add(new OrderItem(3, "macarrão", 2.99, 1));
		orderItems.add(new OrderItem(4, "bacon", 6.29, 1));
		orderItems.add(new OrderItem(5, "pasta de dente", 3.99, 1));
		orderItems.add(new OrderItem(6, "escova de dentes", 17.25, 1));
		orderList.add(new Order(1, new Date(), "Entregue",orderItems, new Payment(1,"processando", "1234562", new Date())));
	}
	
	
}
