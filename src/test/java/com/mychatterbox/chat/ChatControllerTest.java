package com.mychatterbox.chat;

import com.mychatterbox.hello.HelloWorldControllerTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChatControllerTest {

  private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldControllerTest.class);
  @Autowired private RestController restController;

  @Test
  void testGetAllRooms(@Autowired TestRestTemplate testRestTemplate) {
    List<String> roomList = Arrays.asList("Raum1", "Raum2", "Raum3");
    ResponseEntity<String[]> response = testRestTemplate.getForEntity("/rooms", String[].class);
    assertThat(response.getBody()[0]).isEqualTo(roomList.get(0));
    assertThat(response.getBody()[1]).isEqualTo(roomList.get(1));
    assertThat(response.getBody()[2]).isEqualTo(roomList.get(2));
  }
}
