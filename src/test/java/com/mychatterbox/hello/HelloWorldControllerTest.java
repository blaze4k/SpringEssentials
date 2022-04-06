package com.mychatterbox.hello;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldControllerTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldControllerTest.class);
  @Autowired private HelloWorldController helloWorldController;
  @LocalServerPort private int localServerPort;

  @Test
  void testHello() {
    LOGGER.info("Testing 'testHello() on Port: " + localServerPort);
    assertThat(helloWorldController.hello()).isEqualTo("Hello World");
  }

  @Test
  void testHelloQuery(@Autowired TestRestTemplate testRestTemplate) {
    LOGGER.info("Testing 'testHelloQuery() on Port: " + localServerPort);
    final String greeting = "Moin moin";
    ResponseEntity<String> response =
        testRestTemplate.getForEntity(
            "/hello/helloQuery?greeting={greeting}", String.class, greeting);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo(greeting + "user!");
  }

  @Test
  void testHelloParam(@Autowired TestRestTemplate testRestTemplate) {
    LOGGER.info("Testing 'testHelloParam() on Port: " + localServerPort);
    final String name = "Benutzer!";
    ResponseEntity<String> response =
        testRestTemplate.getForEntity("/hello/helloPath/{name}", String.class, name);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo("Hello " + name);
  }

  @Test
  void testHelloCombined(@Autowired TestRestTemplate testRestTemplate) {
    LOGGER.info("Testing 'testHelloCombined() on Port: " + localServerPort);
    final String name = "Moin ";
    final String greeting = "Benutzer!";
    ResponseEntity<String> response =
        testRestTemplate.getForEntity(
            "/hello/helloCombined/{name}?greeting={greeting}", String.class, name, greeting);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo(name + greeting);
  }
}
