package com.invilliatest.rest.webservices.restfulwebservices.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invilliatest.rest.webservices.restfulwebservices.store.Store;
import com.invilliatest.rest.webservices.restfulwebservices.store.StoreRepostory;
@Service
public class StoreService {
	
	@Autowired
	private StoreRepostory storeRepostory;
	
	public void updateStore(Store store, Integer id) {
		Store storeRetrieved = storeRepostory.findById(id).get();
		storeRetrieved.setName(store.getName());
		storeRepostory.save(storeRetrieved);
	}
}
