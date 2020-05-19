package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.InquiryRepository;
import com.example.demo.entity.Inquiry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InquiryServiceImpl implements InquiryService {

  private InquiryRepository inquiryRepository;

  @Autowired
  public InquiryServiceImpl(InquiryRepository theInquiryRepository) {
    inquiryRepository = theInquiryRepository;
  }
  
  @Override
  public void save(Inquiry inquiry) {
    inquiryRepository.save(inquiry);
  }

  @Override
  public List<Inquiry> findAll(){
    return inquiryRepository.findAll();
  }

  @Override
  public Inquiry findById(Integer id) {
    return inquiryRepository.findById(id).get();
  }

@Override
public void deleteById(Integer id) {
  inquiryRepository.deleteById(id);
}

}