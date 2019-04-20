package com.invilliatest.rest.webservices.restfulwebservices.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StoreRepostory extends JpaRepository<Store, Integer>{
	@Modifying
    @Query("UPDATE Store s SET s.name = :name WHERE s.id = :id")
    int updateStore(@Param("id") Integer id, @Param("name") String name);
}
