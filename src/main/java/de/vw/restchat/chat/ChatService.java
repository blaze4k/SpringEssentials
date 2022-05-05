package com.mychatterbox.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

  @Autowired RoomsRepository roomsRepository;
  @Autowired ChatRepository chatRepository;

  public Iterable<String> getRooms() {
    return this.roomsRepository.findAll();
  }

  public Iterable<Chat> getMessages() {
    return this.chatRepository.findAll();
  }

  public Iterable<Chat> getMessagesByRoom(String room) {
    return this.chatRepository.findByRoom(room);
  }

  public Chat sendMessagesByRoom(String sender, String room, String message) {
    return this.chatRepository.save(new Chat(sender, room, message));
  }

  public long getMessagesCount() {
    return this.chatRepository.count();
  }
}
