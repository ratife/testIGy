package com.igy.test.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.igy.test.model.User;

public interface UserRepository  extends CrudRepository<User, Long>   {
	
	@Query("select u from User u where u.email = ?1")
	public Object findByEmail(String email) ;
	
}
