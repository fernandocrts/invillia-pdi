package com.invilliatest.rest.webservices.restfulwebservices.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonResource {

	@GetMapping("/person/v1")
	public Person personv1() {
		return new Person("Fernando Salgueiro");
	}
	
	@GetMapping("person/v2")
	public Personv2 personv2() {
		return new Personv2("Fernando", "Salgueiro");
	}
	
	@GetMapping(value = "person/param", params = "1")
	public Person personParamv1() {
		return new Person("Fernando Salgueiro");
	}
	
	@GetMapping(value = "person/param", params = "2")
	public Personv2 personParamv2() {
		return new Personv2("Fernando", "Salgueiro");
	}
	
	@GetMapping(value = "person/header", headers="APPLICATION-PDI=1")
	public Person personHeaderv1() {
		return new Person("Fernando Salgueiro");
	}
	
	@GetMapping(value = "person/header", headers="APPLICATION-PDI=2")
	public Personv2 personHeaderv2() {
		return new Personv2("Fernando", "Salgueiro");
	}
	
	@GetMapping(value = "person/produces", produces = "application/vnd.company.app-v1+json")
	public Person producesv1() {
		return new Person("Fernando Salgueiro");
	}
	
	@GetMapping(value = "person/produces", produces = "application/vnd.company.app-v2+json")
	public Personv2 producesv2() {
		return new Personv2("Fernando", "Salgueiro");
	}
}
