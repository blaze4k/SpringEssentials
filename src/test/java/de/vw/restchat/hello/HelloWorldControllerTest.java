package de.mychatterbox.hello;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import de.vw.restchat.hello.HelloWorldController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = HelloWorldController.class)
class HelloWorldControllerTest {

  private final String greeting = "Hello";
  private final String name = "User";
  @Autowired private MockMvc mvc;

  @Test
  void testHello() throws Exception {
    this.mvc
        .perform(get("/hello/hello"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello World")));
  }

  @Test
  void testHelloQuery() throws Exception {
    this.mvc
        .perform(get("/hello/greeting").param("greeting", this.greeting))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(this.greeting + " user!")));
  }

  @Test
  void testHelloParam() throws Exception {
    this.mvc
        .perform(get("/hello/{name}", this.name))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello " + this.name)));
  }

  @Test
  void testHelloCombined() throws Exception {
    this.mvc
        .perform(get("/hello/{name}", this.name).param("greeting", this.greeting))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(this.greeting + " " + this.name)));
  }
}
