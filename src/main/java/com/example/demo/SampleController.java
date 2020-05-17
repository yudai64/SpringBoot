package com.example.demo;

import java.util.List;

import com.example.demo.dao.InquiryRepository;
import com.example.demo.entity.Inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan("com.example.demo.dao")
public class SampleController {
  @Autowired
  private InquiryRepository inquiryRepository;

  @RequestMapping("/sample")
  public List<Inquiry> get() {
    return inquiryRepository.findAll();
  }
}