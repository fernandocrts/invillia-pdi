package com.invilliatest.rest.webservices.restfulwebservices.store;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.invilliatest.rest.webservices.restfulwebservices.payment.StoreService;

@RestController
public class StoreResource {

	@Autowired
	private StoreRepostory storeRepostory;
	
	@Autowired
	private StoreService storeService;
	
	@PostMapping (path = "/store")
	public void createStore(@RequestBody Store store) {
		storeRepostory.save(store);
	}
	
	@GetMapping(path = "/store/{id}")
	public Optional<Store> retriveStore(@PathVariable Integer id) {
		return storeRepostory.findById(id);
	}
	
	@GetMapping(path = "/stores")
	public List<Store> retriveAllStores() {
		return storeRepostory.findAll();
	}
	
	@PatchMapping(path = "/store/{id}")
	public void updateStore(@RequestBody Store store, @PathVariable Integer id) {
		storeService.updateStore(store, id);
	}
	
	@PatchMapping(path = "/storeHql/{id}")
	public void updateStoreHql(@RequestBody Store store, @PathVariable Integer id) {
		storeRepostory.updateStore(id, store.getName());
	}
}
