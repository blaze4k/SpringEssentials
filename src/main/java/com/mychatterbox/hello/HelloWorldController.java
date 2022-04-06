package com.mychatterbox.hello;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

  @Operation(summary = "THis is a operation code doc.")
  @ApiResponse(description = "This is a API Response message.")
  @GetMapping("/hello")
  public String hello() {
    return "Hello World";
  }

  @GetMapping(path = "/helloQuery")
  public String helloQuery(@RequestParam String greeting) {
    return greeting + "user!";
  }

  @GetMapping(path = "/helloPath/{name}")
  public String helloPath(@PathVariable String name) {
    return "Hello " + name;
  }

  @GetMapping(path = "/helloCombined/{name}")
  public String helloCombinded(@PathVariable String name, @RequestParam String greeting) {
    return name + greeting;
  }
}
