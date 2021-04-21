package com.igy.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class ServerSecurityConfig extends WebSecurityConfigurerAdapter  {
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
		 	// On utilise ces informations au lien de recupérer à dans la base pour aller plus vite.
	        auth.inMemoryAuthentication()
	                .withUser("eric@gmail.com").password("{noop}123").roles("USER")
	                .and()
	                .withUser("jean@gmail.com").password("{noop}123").roles("USER", "ADMIN")
	                .and()
	                .withUser("marc@gmail.com").password("{noop}123").roles("USER", "ADMIN");
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	                .httpBasic()
	                .and()
	                .authorizeRequests()
	                .antMatchers(HttpMethod.GET, "/api/car/list").permitAll()
	                .antMatchers(HttpMethod.GET, "/api/car/comment").hasRole("USER")
	                .antMatchers(HttpMethod.GET, "/api/user").hasRole("USER")
	                //.antMatchers(HttpMethod.GET, "/logout").permitAll()
	                .and()
	                .logout(logout -> logout                                                
	                        .logoutUrl("/logout")                                            
	                        .logoutSuccessUrl("/list_car.html")                                      
	                        .invalidateHttpSession(true)                                        
	                    )
	                .csrf().disable();
	    }
}