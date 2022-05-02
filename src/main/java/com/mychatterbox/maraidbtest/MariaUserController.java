package com.mychatterbox.maraidbtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maria")
public class UserController {

  @Autowired Userrepository userrepository;

  public Iterable<User> getUsers() {
    return this.userrepository.findAll();
  }
}
