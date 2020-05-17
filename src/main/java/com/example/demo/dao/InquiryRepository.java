package com.example.demo.dao;

import com.example.demo.entity.Inquiry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
  
}