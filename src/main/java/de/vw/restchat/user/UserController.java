package com.mychatterbox.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

  @PostMapping(path = "/create")
  public ResponseEntity<User> user(@RequestBody User user) {
    user.setId(UUID.randomUUID().toString());
    return ResponseEntity.status(HttpStatus.CREATED).body(user);
  }
}
