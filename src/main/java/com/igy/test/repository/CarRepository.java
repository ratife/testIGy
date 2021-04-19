package com.igy.test.repository;

import org.springframework.data.repository.CrudRepository;

import com.igy.test.model.Car;

public interface CarRepository  extends CrudRepository<Car, Long>   {
	
}
