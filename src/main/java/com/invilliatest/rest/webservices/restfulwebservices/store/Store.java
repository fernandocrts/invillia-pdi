package com.invilliatest.rest.webservices.restfulwebservices.store;

public class Store {
	
	private Integer id;
	
	private String name;

	public Store(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + "]";
	}

}
