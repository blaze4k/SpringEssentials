package de.vw.restchat.chat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.Instant;
import org.junit.jupiter.api.Test;

public class ChatTest {

  @Test
  void testConstructorZero() {
    Chat chatZero = new Chat();
    assertNull(chatZero.getMessage());
    assertNull(chatZero.getPosted());
    assertNull(chatZero.getRoom());
    assertNull(chatZero.getSender());
  }

  @Test
  void testConstructorLong() {
    Instant instant = Instant.now();
    Chat chatZero = new Chat("Sender", instant, "Room", "Message");
    assertNotNull(chatZero.getMessage());
    assertNotNull(chatZero.getPosted());
    assertNotNull(chatZero.getRoom());
    assertNotNull(chatZero.getSender());
    assertEquals("Message", chatZero.getMessage());
    assertEquals(instant, chatZero.getPosted());
    assertEquals("Room", chatZero.getRoom());
    assertEquals("Sender", chatZero.getSender());
  }

  @Test
  void testConstructorMedium() {
    Instant instant = Instant.now();
    Chat chatZero = new Chat("Sender", "Room", "Message");
    assertNotNull(chatZero.getMessage());
    assertNotNull(chatZero.getRoom());
    assertNotNull(chatZero.getSender());
    assertEquals("Message", chatZero.getMessage());
    assertEquals("Room", chatZero.getRoom());
    assertEquals("Sender", chatZero.getSender());
  }
}
