package com.mychatterbox.chat;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Configuration
public class GoogleSheetsConfig {

  @Autowired private GoogleSheetsRoomsProperties googleSheetsRoomsProperties;

  @Bean
  public Sheets roomSheets() throws GeneralSecurityException, IOException {
    NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
    GoogleClientRequestInitializer KEY_INITIALIZER =
        CommonGoogleClientRequestInitializer.newBuilder()
            .setKey(googleSheetsRoomsProperties.getApiKey())
            .build();
    return new Sheets.Builder(HTTP_TRANSPORT, JacksonFactory.getDefaultInstance(), null)
        .setGoogleClientRequestInitializer(KEY_INITIALIZER)
        .build();
  }
}
