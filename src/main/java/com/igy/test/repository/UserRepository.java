package com.igy.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.igy.test.model.User;

public interface UserRepository  extends CrudRepository<User, Long>   {
	
}
