package com.igy.test.controller;

@SpringBootApplication
@RestController
@EnableAuthorizationServer
@EnableResourceServer

public class AuthApi {
  @RequestMapping("/user")
  public Principal user(Principal user) {
    return user;
  }
}
