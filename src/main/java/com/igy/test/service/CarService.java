package com.igy.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igy.test.model.Car;
import com.igy.test.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired 
	private CarRepository carRepository;

	public List<Car> getAllCars() {
		return (List<Car>) carRepository.findAll();
	}
	
}
