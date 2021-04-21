package com.igy.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.igy.test.model.Car;
import com.igy.test.model.Comment;
import com.igy.test.service.CarService;


@Controller
@RestController
public class ApiController {
	@Autowired  
	private CarService carService;
	
	@GetMapping("api/car/list")  
	private List<Car> getAllCar() {  
		List<Car> list = carService.getAllCars();
		return list;  
	} 
	
	@GetMapping(value = "api/car/comment")
	private Comment postComment(final HttpServletRequest request) {  
		
		String comment = request.getParameter("comment");
		String carId = request.getParameter("carId");
		String id = request.getParameter("id");
		
		return carService.commentCar(Long.parseLong(carId),Long.parseLong(id),comment);
	} 
}
