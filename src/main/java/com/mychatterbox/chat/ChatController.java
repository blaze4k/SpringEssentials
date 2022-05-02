package com.mychatterbox.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

  @Autowired ChatService chatService;

  @GetMapping("/rooms")
  public Iterable<String> getRooms() {
    return chatService.getRooms();
  }

  @GetMapping("/messages")
  public Iterable<Chat> getMessages() {
    return chatService.getMessages();
  }

  @PostMapping("/messages/{room}/show")
  public Iterable<Chat> getMessagesByRoom(@PathVariable String room) {
    return chatService.getMessagesByRoom(room);
  }

  @PostMapping("/messages/{room}/send")
  public Chat sendMessagesByRoom(
      @RequestParam String sender, @PathVariable String room, @RequestParam String message) {
    return chatService.sendMessagesByRoom(sender, room, message);
  }

  @GetMapping("/messages/count")
  public long getMessagesCount() {
    return this.chatService.getMessagesCount();
  }
}
