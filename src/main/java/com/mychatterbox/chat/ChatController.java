package com.mychatterbox.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

  @Autowired private RoomsRepository roomsRepository;

  @GetMapping("/rooms")
  public Iterable<String> getRooms() {
    return roomsRepository.findAll();
  }
}
