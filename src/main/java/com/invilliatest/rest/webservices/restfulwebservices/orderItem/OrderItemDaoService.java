package com.invilliatest.rest.webservices.restfulwebservices.orderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoService {
	private static List<OrderItem> orderItemList = new ArrayList<>();
	private static int countOrderItem = 6;
	static {
		orderItemList.add(new OrderItem(1, "feijao", 4.0, 1));
		orderItemList.add(new OrderItem(2, "arroz", 3.99, 1));
		orderItemList.add(new OrderItem(3, "macarrão", 2.99, 1));
		orderItemList.add(new OrderItem(4, "bacon", 6.29, 1));
		orderItemList.add(new OrderItem(5, "pasta de dente", 3.99, 1));
		orderItemList.add(new OrderItem(6, "escova de dentes", 17.25, 1));
	}
	
	public List<OrderItem> findAll(){
		return orderItemList;
	}
	
	public OrderItem findOne(int id) {
		for (OrderItem orderItem : orderItemList) {
			if(orderItem.getId() == id) {
				return orderItem;
			}
		}
		return null;
	}
	
	public OrderItem save(OrderItem orderItem) {
		if(orderItem.getId() == null) {
			orderItem.setId(++countOrderItem);
		}
		
		orderItemList.add(orderItem); 
		return orderItem;
	}
}
