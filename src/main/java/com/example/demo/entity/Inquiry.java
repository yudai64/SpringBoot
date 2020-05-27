package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inquiry")
public class Inquiry {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String email;

  private String content;

  public Inquiry() {

  }
  
  public Inquiry(String name, String email, String content) {
    this.setName(name);
    this.setEmail(email);
    this.setContent(content);
}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}