package com.invilliatest.rest.webservices.restfulwebservices.person;

public class Personv2 {

	private Name name;
	
	public Personv2(Name name) {
		super();
		this.name = name;
	}
	
	public Name getLastName() {
		return name;
	}
	
	public void setName(Name name) {
		this.name = name;
	}
	
}
