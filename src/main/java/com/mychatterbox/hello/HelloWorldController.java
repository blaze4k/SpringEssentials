package com.mychatterbox.hello;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

  @Operation(summary = "This is a operation code doc.")
  @ApiResponse(description = "This is a API Response message.")
  @GetMapping("/hello")
  public String hello() {
    return "Hello World";
  }

  @GetMapping(path = "/greeting")
  public String helloQuery(@RequestParam String greeting) {
    return greeting + " user!";
  }

  @GetMapping(path = "/{name}")
  public String helloPath(@PathVariable String name) {
    return "Hello " + name;
  }

  @GetMapping(path = "/combined/{name}")
  public String helloCombinded(@PathVariable String name, @RequestParam String greeting) {
    return greeting + " " + name;
  }
}
