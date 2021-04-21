package com.igy.test.controller;

import java.security.Principal;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.igy.test.service.UserService;

@SpringBootApplication
@RestController
public class AuthApi {
	//@Autowired  
	//private UserService userService;
	
	//@Autowired 
	//private final PasswordEncoder passwordEncoder;
	
  @RequestMapping("/user")
  public Principal user(Principal user) {
    return user;
  }
  
  /*
  @GetMapping("/findByEmail")
  //@PreAuthorize("!hasAuthority('USER') || (authentication.principal == #email)")
  User findByEmail(@RequestParam String email, OAuth2Authentication authentication) {
      User user = (User) userService.loadUserByUsername(email);
      if(user!=null)return user;
      throw new EntityNotFoundException("Email not fond :" +email);
  }*/
}
