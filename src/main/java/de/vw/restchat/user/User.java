package com.mychatterbox.user;

public class User {

  private String id;
  private String foreName;
  private String lastName;
  private int age;
  private String email;
  private String userLevel;

  public User() {}

  public User(
      String id, String foreName, String lastName, int age, String email, String userLevel) {
    this.id = id;
    this.foreName = foreName;
    this.lastName = lastName;
    this.age = age;
    this.email = email;
    this.userLevel = userLevel;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getForeName() {
    return foreName;
  }

  public void setForeName(String foreName) {
    this.foreName = foreName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserLevel() {
    return userLevel;
  }

  public void setUserLevel(String userLevel) {
    this.userLevel = userLevel;
  }
}
