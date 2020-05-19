package com.example.demo.inquiry;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class InquiryForm {

  @NotBlank(message = "名前を入力してください")
  private String name;

  @NotBlank(message = "メールアドレスを入力してください")
  @Email(message = "正しい表記で記入してください")
  private String email;

  @NotBlank(message = "お問い合わせ内容を入力してください")
  private String content;

  public InquiryForm() {

  }

  public String getName() {
    return name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setName(String name) {
    this.name = name;
  }
}