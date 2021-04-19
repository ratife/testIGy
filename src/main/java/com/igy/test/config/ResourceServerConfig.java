package com.igy.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .httpBasic()
    .and()
      .authorizeRequests()
        .antMatchers("/index.html", "/", "/home", "/login").permitAll()
        .anyRequest().authenticated();
  }
  
    @Bean
	public UserDetailsService users() throws Exception {
		User.UserBuilder users = User.withDefaultPasswordEncoder();
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(users.username("user1").password("123").roles("USER").build());
		manager.createUser(users.username("admin").password("123").roles("USER", "ADMIN").build());
		return manager;
	}
}
