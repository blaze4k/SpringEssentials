package de.mychatterbox.chat;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;
import de.vw.restchat.chat.Chat;
import de.vw.restchat.chat.ChatController;
import de.vw.restchat.chat.ChatService;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = ChatController.class)
class ChatControllerTest {

  private final Chat msg = new Chat("Ich", LocalDateTime.now(), "Java", "Hello World");
  private final List<String> testList = Arrays.asList("Test1", "Test2");
  private final String json = new Gson().toJson(testList);
  @Autowired private MockMvc mvc;
  @MockBean private ChatService chatService;

  @Test
  void testGetRooms() throws Exception {
    given(this.chatService.getRooms()).willReturn(this.testList);
    this.mvc
        .perform(get("/chat/rooms"))
        .andExpect(status().isOk())
        .andExpect(content().string(json));
    then(chatService).should(times(1)).getRooms();
  }

  @Test
  void testGetMessages() throws Exception {
    given(this.chatService.getMessages()).willReturn(Arrays.asList(this.msg));
    this.mvc
        .perform(get("/chat/messages"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$..message").value(this.msg.getMessage()))
        .andExpect(jsonPath("$..room").value(this.msg.getRoom()))
        .andExpect(jsonPath("$..sender").value(this.msg.getSender()));
  }

  @Test
  void testGetMessagesByRoom() throws Exception {
    given(this.chatService.getMessagesByRoom("Java"))
        .willReturn(Collections.singletonList(this.msg));
    this.mvc
        .perform(post("/chat/messages/{room}/show", this.msg.getRoom()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$..message").value(this.msg.getMessage()))
        .andExpect(jsonPath("$..room").value(this.msg.getRoom()))
        .andExpect(jsonPath("$..sender").value(this.msg.getSender()));
  }

  @Test
  void testGetMessageCount() throws Exception {
    given(this.chatService.getMessagesCount()).willReturn(5L);
    this.mvc.perform(get("/chat/messages/count")).andExpect(content().string(String.valueOf(5L)));
  }
}
