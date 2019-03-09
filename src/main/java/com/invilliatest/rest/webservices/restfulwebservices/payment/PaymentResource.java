package com.invilliatest.rest.webservices.restfulwebservices.payment;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PaymentResource {

	@Autowired
	private PaymentDaoService paymentDaoService;

	@GetMapping(path = "/payments")
	public List<Payment> retrieveAllPayments() {
		return paymentDaoService.findAll();
	}

	@GetMapping(path = "/payments/{id}")
	public Payment retrievePayment(@PathVariable int id) throws PaymentNotFoundException {
		Payment payment = paymentDaoService.findOne(id);
		
		if(payment == null)
			throw new PaymentNotFoundException("id - " + id);
		
		return paymentDaoService.findOne(id);
	}

	@PostMapping("/payments")
	public ResponseEntity<Object> createPayment(@RequestBody Payment payment) {
		Payment savedPayment = paymentDaoService.save(payment);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPayment.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/payments/{id}")
	public ResponseEntity<Object> deletePayment(@PathVariable int id){
		Payment deletedPayment = paymentDaoService.deleteById(id);
		
		if (deletedPayment == null)
			throw new PaymentNotFoundException("id - " + id);
		
		return ResponseEntity.noContent().build();
	}
}
