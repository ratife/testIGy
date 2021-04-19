package com.igy.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igy.test.config.HttpSecurity;
import com.igy.test.config.WebSecurityConfigurerAdapter;

@RestController
@SpringBootApplication
@EnableAuthorizationServer
public class TestApplication{
	
	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .httpBasic()
	    .and()
	      .authorizeRequests()
	        .antMatchers("/index.html", "/", "/home", "/login").permitAll()
	        .anyRequest().authenticated();
	  }
	}

	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
}
