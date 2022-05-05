package de.mychatterbox.mail;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.vw.restchat.mail.Mail;
import de.vw.restchat.mail.MailController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = MailController.class)
class MailControllerTest {

  @Autowired private MockMvc mvc;
  @Autowired private ObjectMapper objectMapper;

  @Test
  void testMail() throws Exception {
    Mail mail = new Mail("User", "Message");
    this.mvc
        .perform(
            post("/mail/send")
                .content(objectMapper.writeValueAsString(mail))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$..sender").value(mail.getSender()))
        .andExpect(jsonPath("$..msg").value(mail.getMsg()));
  }
}
