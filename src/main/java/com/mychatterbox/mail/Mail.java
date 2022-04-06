package com.mychatterbox.mail;

public class Mail {

  private String sender;
  private String msg;

  public Mail() {}

  public Mail(String sender, String msg) {
    this.sender = sender;
    this.msg = msg;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
