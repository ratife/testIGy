package com.igy.test;

import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TestApplication{

	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
	@RequestMapping("/token")
	public Map<String,String> token(HttpSession session) {
	   return Collections.singletonMap("token", session.getId());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
}
