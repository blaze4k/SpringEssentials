package com.mychatterbox.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

  @Test
  void testUser(@Autowired TestRestTemplate testRestTemplate) {
    User myUser = new User();
    myUser.setForeName("Max");
    myUser.setLastName("Mustermann");
    myUser.setAge(30);
    myUser.setEmail("max.mustermann@mail.com");
    myUser.setUserLevel("Admin");
    ResponseEntity<User> response =
        testRestTemplate.postForEntity("/user/create", new HttpEntity<>(myUser), User.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getBody().getForeName()).isEqualTo("Max");
    assertThat(response.getBody().getLastName()).isEqualTo("Mustermann");
    assertThat(response.getBody().getAge()).isEqualTo(30);
    assertThat(response.getBody().getEmail()).isEqualTo("max.mustermann@mail.com");
    assertThat(response.getBody().getUserLevel()).isEqualTo("Admin");
  }
}
