package com.igy.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igy.test.model.User;
import com.igy.test.repository.UserRepository;

@Service
public class UserService /*implements UserDetailsService*/{
	
	@Autowired 
	private UserRepository userRepository;
	/*
	@Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = (User) userRepository.findByEmail(username);
       if(user==null) throw new RuntimeException("User not found: " + username);
       GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
       return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Arrays.asList(authority));
   }
	*/
	public User save(User u) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
