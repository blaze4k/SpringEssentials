package com.mychatterbox.chat;

import java.time.LocalDateTime;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Chat {

  @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
  private String sender;

  @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
  private LocalDateTime posted;

  @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
  private String room;

  @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
  private String message;

  public Chat() {}

  public Chat(String sender, LocalDateTime posted, String room, String message) {
    this.sender = sender;
    this.posted = posted;
    this.room = room;
    this.message = message;
  }

  public Chat(String sender, String room, String message) {
    this.sender = sender;
    this.posted = LocalDateTime.now();
    this.room = room;
    this.message = message;
  }

  public String getSender() {
    return sender;
  }

  public LocalDateTime getPosted() {
    return posted;
  }

  public String getRoom() {
    return room;
  }

  public String getMessage() {
    return message;
  }
}
