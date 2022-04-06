package com.mychatterbox.mail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MailControllerTest {

  @Test
  void testMail(@Autowired TestRestTemplate testRestTemplate) {
    Mail myMail = new Mail();
    myMail.setSender("Obi-Wan");
    myMail.setMsg("Hello there");
    ResponseEntity<Mail> response =
        testRestTemplate.postForEntity("/mail/send", new HttpEntity<>(myMail), Mail.class);
    System.out.printf(response.getBody().toString());
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getBody().getSender()).isEqualTo("Obi-Wan");
    assertThat(response.getBody().getMsg()).isEqualTo("Hello there");
  }
}
