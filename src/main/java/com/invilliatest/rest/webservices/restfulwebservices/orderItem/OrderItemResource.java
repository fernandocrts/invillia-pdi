package com.invilliatest.rest.webservices.restfulwebservices.orderItem;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderItemResource {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/orderitems")
	public List<OrderItem> retrieveAllItens(){
		List<OrderItem> orderItems = orderRepository.findAll();
		return orderItems;
	}
	
	@GetMapping(path = "/orderitems/{id}")
	public OrderItem retrieveOrderItem(@PathVariable int id) {
		Optional<OrderItem> orderItem = orderRepository.findById(id);
		return orderItem.get();
	}
	
	@PostMapping("/orderitems")
	public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
		OrderItem savedOrderItem = orderRepository.save(orderItem);
		return savedOrderItem;
	}
	
	@DeleteMapping("/orderitems/{id}")
	public void deleteOrderItem(@PathVariable int id) {
		orderRepository.deleteById(id);
	}
}
