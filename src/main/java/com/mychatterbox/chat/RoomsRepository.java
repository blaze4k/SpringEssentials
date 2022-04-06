package com.mychatterbox.chat;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Lists;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RoomsRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(RoomsRepository.class);
  private final String range = "Rooms";
  private final String majorDimension = "COLUMNS";
  @Autowired private GoogleSheetsRoomsProperties googleSheetsRoomsProperties;

  //  @Value("${google.sheets.rooms.sheetId}")
  //  private String spreadsheetId;
  //
  //  @Value("${google.sheets.rooms.apiKey}")
  //  private String apiKey;

  public List<String> findAll() {
    List<String> rooms = Lists.newArrayList();
    try {
      NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
      GoogleClientRequestInitializer KEY_INITIALIZER =
          CommonGoogleClientRequestInitializer.newBuilder()
              .setKey(googleSheetsRoomsProperties.getApiKey())
              .build();
      Sheets service =
          new Sheets.Builder(HTTP_TRANSPORT, JacksonFactory.getDefaultInstance(), null)
              .setGoogleClientRequestInitializer(KEY_INITIALIZER)
              .build();
      ValueRange result =
          service
              .spreadsheets()
              .values()
              .get(googleSheetsRoomsProperties.getSheetId(), range)
              .setMajorDimension(majorDimension)
              .execute();
      List<Object> values = result.getValues().get(0);
      rooms = values.stream().map(Object::toString).collect(Collectors.toList());
    } catch (GeneralSecurityException | IOException e) {
      LOGGER.error("Something went wrong when I tried to retrieve the rooms from Google Sheets", e);
    }
    return rooms;
  }
}