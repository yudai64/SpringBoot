package com.example.demo.inquiry;

import java.util.List;

import com.example.demo.entity.Inquiry;
import com.example.demo.service.InquiryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/inquiry")
public class InquiryController {
  
  @Autowired
  private InquiryService inquiryService;

  @GetMapping("index")
  public String index(Model model) {
    List <Inquiry> list = inquiryService.findAll();
    model.addAttribute("title", "問い合わせ一覧ページ");
    model.addAttribute("inquiryList", list);
    return "inquiry/index";
  }

  @GetMapping("/form")
  public String form(InquiryForm inquiryForm, Model model) {
    model.addAttribute("title", "新規問い合わせページ");
    return "inquiry/form";
  }

  @PostMapping("/form")
  public String formBack(InquiryForm inquiryForm, Model model) {
    model.addAttribute("title", "新規問い合わせページ");
    return "inquiry/form";
  }

  @PostMapping("/confirm")
  public String confirm(
    @Validated InquiryForm inquiryForm,
    BindingResult result,
    Model model
  ) {

    if (result.hasErrors()) {
      model.addAttribute("title", "新規問い合わせページ");
    return "inquiry/form";
    }
    model.addAttribute("title", "確認ページ");
    return "inquiry/confirm";
  }

  @PostMapping("/index")
  public String save(Inquiry inquiry, InquiryForm inquiryForm, Model model) {
    inquiry.setName(inquiryForm.getName());
    inquiry.setEmail(inquiryForm.getEmail());
    inquiry.setContent(inquiryForm.getContent());
    inquiryService.save(inquiry);
    List <Inquiry> list = inquiryService.findAll();
    model.addAttribute("title", "問い合わせ一覧ページ");
    model.addAttribute("inquiryList", list);
    return "inquiry/index";
  }

}