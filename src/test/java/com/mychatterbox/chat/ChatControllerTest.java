package com.mychatterbox.chat;

import com.mychatterbox.hello.HelloWorldControllerTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChatControllerTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldControllerTest.class);

  @Test
  void roomsReturnsRooms(@Autowired TestRestTemplate restTemplate) {
    List<String> rooms =
        new ArrayList<>(
            Arrays.asList(
                "Java",
                "Spring Boot",
                "Cars",
                "Moin moin",
                "Moep",
                "Huhu",
                "super",
                "C#",
                "Leons Room",
                "Marius",
                "Bester Raum",
                "Hallo ihr da",
                "Funktioniert",
                "Gleich ist Feierabend",
                "Noch sechs Minuten",
                "Ist irgendwer hier?"));
    ResponseEntity<String[]> response = restTemplate.getForEntity("/rooms", String[].class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    String[] responseRooms = response.getBody();
    for (int i = 0; i < rooms.size(); i++) {
      assertThat(rooms.get(i)).isEqualTo(responseRooms[i]);
    }
  }
}
