package com.mychatterbox.maraidbtest;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class User {

  @Column private String name;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  public User(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }
}
