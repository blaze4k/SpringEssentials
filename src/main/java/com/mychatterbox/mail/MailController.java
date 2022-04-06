package com.mychatterbox.mail;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {

  @PostMapping(path = "/send")
  @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "This is a RequestBody description.")
  public ResponseEntity<Mail> mail(@RequestBody Mail mail) {
    return ResponseEntity.status(HttpStatus.CREATED).body(mail);
  }
}
