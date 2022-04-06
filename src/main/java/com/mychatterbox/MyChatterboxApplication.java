package com.mychatterbox;

import com.mychatterbox.chat.GoogleSheetsRoomsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GoogleSheetsRoomsProperties.class)
public class MyChatterboxApplication {

  public static void main(String[] args) {
    SpringApplication.run(MyChatterboxApplication.class, args);
  }
}
