package com.invilliatest.rest.webservices.restfulwebservices.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderResource {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@PostMapping(path = "/orders")
	public void createOrder(@RequestBody Order order) {
		orderRepository.save(order);
	}
	
	@GetMapping(path = "/orders")
	public List<Order> getOrders(){
		List<Order> orders = orderRepository.findAll();
		return orders;
	}
}
