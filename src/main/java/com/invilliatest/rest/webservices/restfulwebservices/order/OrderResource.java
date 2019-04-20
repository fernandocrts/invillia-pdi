package com.invilliatest.rest.webservices.restfulwebservices.order;

import org.springframework.beans.factory.annotation.Autowired;
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
}
