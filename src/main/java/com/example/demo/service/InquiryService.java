package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Inquiry;

public interface InquiryService {

  public void save(Inquiry inquiry);

  public List<Inquiry> findAll();

  public Inquiry findById(Integer id);

  public void deleteById(Integer id);
  
}