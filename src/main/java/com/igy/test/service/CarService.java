package com.igy.test.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igy.test.model.Car;
import com.igy.test.model.Comment;
import com.igy.test.repository.CarRepository;
import com.igy.test.repository.CommentRepository;
import com.igy.test.repository.UserRepository;

@Service
public class CarService {
	
	@Autowired 
	private CarRepository carRepository;
	
	@Autowired
	private CommentRepository comRepository;
	
	@Autowired
	private UserRepository userRepository;

	public List<Car> getAllCars() {
		return (List<Car>) carRepository.findAll();
	}

	public Comment commentCar(Long carId, Long userId, String comment) {
		Comment com = new Comment();
		com.setCarId(carId);
		com.setComment(comment);
		com.setUser(userRepository.findById(userId).get());
		com.setDate(new Date());
		return comRepository.save(com);
	}
	
}
