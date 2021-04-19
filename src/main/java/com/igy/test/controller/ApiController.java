package com.igy.test.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igy.test.model.Car;
import com.igy.test.service.CarService;


@RestController
public class ApiController {
	@Autowired  
	private CarService carService;
	
	@GetMapping("/car/list")  
	@CrossOrigin(origins="*", maxAge=3600)
	private List<Car> getAllCar() {  
		return carService.getAllCars();  
	}  
	//Comment controlleur
	
	//login
}
