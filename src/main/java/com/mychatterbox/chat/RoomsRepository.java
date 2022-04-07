package com.mychatterbox.chat;

import com.google.api.client.util.Lists;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RoomsRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(RoomsRepository.class);
  @Autowired private GoogleSheetsRoomsProperties googleSheetsRoomsProperties;

  @Autowired private Sheets roomSheets;

  //  @Value("${google.sheets.rooms.sheetId}")
  //  private String spreadsheetId;
  //
  //  @Value("${google.sheets.rooms.apiKey}")
  //  private String apiKey;

  public List<String> findAll() {
    List<String> rooms = Lists.newArrayList();
    try {
      ValueRange result =
          this.roomSheets
              .spreadsheets()
              .values()
              .get(googleSheetsRoomsProperties.getSheetId(), googleSheetsRoomsProperties.getRange())
              .setMajorDimension(googleSheetsRoomsProperties.getMajor())
              .execute();
      List<Object> values = result.getValues().get(0);
      rooms = values.stream().map(Object::toString).collect(Collectors.toList());
    } catch (IOException e) {
      LOGGER.error("Something went wrong when I tried to retrieve the rooms from Google Sheets", e);
    }
    return rooms;
  }
}
