package com.mychatterbox.chat;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("google.sheets.rooms")
public class GoogleSheetsRoomsProperties {

  private String apiKey;
  private String sheetId;
  private String range;
  private String major;

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

  public String getRange() {
    return range;
  }

  public void setRange(String range) {
    this.range = range;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }
}
