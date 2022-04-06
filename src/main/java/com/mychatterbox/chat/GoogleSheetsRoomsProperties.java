package com.mychatterbox.chat;

import com.google.api.services.sheets.v4.model.Sheet;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("google.sheets.rooms")
public class GoogleSheetsRoomsProperties {

  private String apiKey;
  private String sheetId;

  public Sheet getSheet() {
    return null;
  }

  public String getApiKey() {
    return apiKey;
  }

  public void setApiKey(String apiKey) {
    this.apiKey = apiKey;
  }

  public String getSheetId() {
    return sheetId;
  }

  public void setSheetId(String sheetId) {
    this.sheetId = sheetId;
  }
}
