package com.mychatterbox.chat;

import org.springframework.data.repository.CrudRepository;

public interface ChatRepository extends CrudRepository<Chat, Chat> {

  String save(String room);

  Iterable<Chat> findByRoom(String room);
}
