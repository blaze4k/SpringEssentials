package com.mychatterbox.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

  @Autowired private MockMvc mvc;
  @Autowired private ObjectMapper objectMapper;

  @Test
  void testUser() throws Exception {
    User user = new User();
    user.setForeName("Max");
    user.setLastName("Mustermann");
    user.setAge(30);
    user.setEmail("max.mustermann@mail.com");
    user.setUserLevel("Admin");
    this.mvc
        .perform(
            post("/user/create")
                .content(objectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$..foreName").value(user.getForeName()))
        .andExpect(jsonPath("$..lastName").value(user.getLastName()))
        .andExpect(jsonPath("$..age").value(user.getAge()))
        .andExpect(jsonPath("$..email").value(user.getEmail()))
        .andExpect(jsonPath("$..userLevel").value(user.getUserLevel()));
  }
}
