package com.igy.test.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igy.test.model.Car;
import com.igy.test.model.Comment;
import com.igy.test.model.User;
import com.igy.test.repository.UserRepository;
import com.igy.test.service.CarService;

@Controller
@RestController
public class ApiController {
	@Autowired  
	private CarService carService;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("api/car/list")  
	private List<Car> getAllCar(Principal user) {  
		List<Car> list = list = carService.getAllCars();
		if(user==null) {
			list.stream().forEach(car->car.setComments(null));
		}
		return list;  
	} 
	
	@GetMapping(value = "api/car/comment")
	private Comment postComment(final HttpServletRequest request,Principal user) {  
		String comment = request.getParameter("comment");
		String carId = request.getParameter("carId");
		User us = (User) userRepository.findByEmail(user.getName());
		return carService.commentCar(Long.parseLong(carId),us,comment);
	}
	
	@RequestMapping("/api/user")
	  public User user(Principal user) {
		  User us = (User) userRepository.findByEmail(user.getName());
		  return us;
	  }
}
