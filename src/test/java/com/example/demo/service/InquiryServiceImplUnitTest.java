package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dao.InquiryRepository;
import com.example.demo.entity.Inquiry;
// import com.example.demo.service.InquiryServiceImpl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
// import org.mockito.verification.VerificationMode;

@ExtendWith(MockitoExtension.class)
@DisplayName("InquiryServiceImplの単体テスト")
public class InquiryServiceImplUnitTest {

  @Mock
  InquiryRepository inquiryRepository;

  @InjectMocks
  InquiryServiceImpl inquiryServiceImpl;

  @Test
  @DisplayName("findallメソッドのテスト")
  public void testFindAll() {

    List<Inquiry> list = new ArrayList<>();
    Inquiry inquiry1 = new Inquiry();
    Inquiry inquiry2 = new Inquiry();
    Inquiry inquiry3 = new Inquiry();
    list.add(inquiry1);
    list.add(inquiry2);
    list.add(inquiry3);

    when(inquiryRepository.findAll()).thenReturn(list);

    List<Inquiry> testList = inquiryServiceImpl.findAll();

    verify(inquiryRepository, times(1)).findAll();

    assertEquals(3, testList.size());

  }

  @Test
  @DisplayName("saveメソッドのテスト")
  public void testSave() {

    Inquiry inquiry = new Inquiry();

    inquiryServiceImpl.save(inquiry);

    verify(inquiryRepository, times(1)).save(inquiry);

  }


}