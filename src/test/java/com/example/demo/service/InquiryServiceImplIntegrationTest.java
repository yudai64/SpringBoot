package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.demo.entity.Inquiry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringBootTest
@SpringJUnitConfig
// @ActiveProfiles
public class InquiryServiceImplIntegrationTest {
  
  @Autowired
  InquiryServiceImpl inquiryServiceImpl;

  @DisplayName("findAllメソッドのテスト")
  @Test
  public void findAllメソッドのテスト() {

    List<Inquiry> list = inquiryServiceImpl.findAll();

   assertEquals(5,list.size());

   }

   @DisplayName("saveメソッドのテスト")
   @Test
   public void saveメソッドのテスト() {

    Inquiry inquiry = new Inquiry();
    // inquiry.setId(7);
    inquiry.setName("早見");
    inquiry.setEmail("blue@mcz.com");
    inquiry.setContent("早見さんのテスト用投稿です。");

    inquiryServiceImpl.save(inquiry);

    String name = inquiry.getName();
    String email = inquiry.getEmail();
    String content = inquiry.getContent();

    assertEquals("早見", name);
    assertEquals("blue@mcz.com", email);
    assertEquals("早見さんのテスト用投稿です。", content);

  }

  @DisplayName("findByIdメソッドのテスト")
  @Test
  public void findByIdメソッドのテスト() {

    Inquiry inquiry = inquiryServiceImpl.findById(1);

    String name = inquiry.getName();
    String email = inquiry.getEmail();
    String content = inquiry.getContent();

    assertEquals("百田", name);
    assertEquals("red@mcz.com", email);
    assertEquals("百田さんのテスト用投稿です。", content);

   }

}