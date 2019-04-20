package com.invilliatest.rest.webservices.restfulwebservices.payment;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.invilliatest.rest.webservices.restfulwebservices.Exception.Payment.PaymentNotFoundException;

@RestController
public class PaymentResource{

	@Autowired
	private PaymentRepository paymentRepository;
	
	@GetMapping(path = "/payments")
	public MappingJacksonValue retrieveAllPayments() {
		List<Payment> payments = paymentRepository.findAll();
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("id","status","paymentDate");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("PaymentFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(payments);
		mapping.setFilters(filters);
		
		return mapping;
	}

	@GetMapping(path = "/payments/{id}")
	public MappingJacksonValue retrievePayment(@PathVariable int id) throws PaymentNotFoundException {
		Optional<Payment> payment = paymentRepository.findById(id);
		if(!payment.isPresent())
			throw new PaymentNotFoundException("id - " + id);
		
		EntityModel<Payment> paymentEntityModel = new EntityModel<Payment>(payment.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllPayments());
		paymentEntityModel.add(linkTo.withRel("all-payments"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
				.filterOutAllExcept("id","status","creditcardNumber","paymentDate");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("PaymentFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(paymentEntityModel);
		mapping.setFilters(filters);
		
		return mapping;
	}

	@PostMapping("/payments")
	public ResponseEntity<Object> createPayment(@Valid @RequestBody Payment payment) {
		Payment savedPayment = paymentRepository.save(payment);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPayment.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/payments/{id}")
	public void deletePayment(@PathVariable int id){
		paymentRepository.deleteById(id);
	}
}
