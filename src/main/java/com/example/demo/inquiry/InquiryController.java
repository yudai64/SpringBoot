package com.example.demo.inquiry;

import java.util.List;

import com.example.demo.entity.Inquiry;
import com.example.demo.service.InquiryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/inquiry")
public class InquiryController {
  
  private InquiryService inquiryService;

  @Autowired
  public InquiryController(InquiryService theInquiryService) {
    inquiryService = theInquiryService;
  }

  //新規問い合わせページに遷移
  @GetMapping("/form")
  public String form(InquiryForm inquiryForm, Model model) {
    model.addAttribute("title", "新規問い合わせページ");
    return "inquiry/form";
  }

  //お問い合わせ一覧ページに遷移
  @GetMapping("index")
  public String index(Model model) {
    List <Inquiry> list = inquiryService.findAll();
    model.addAttribute("title", "お問い合わせ一覧ページ");
    model.addAttribute("inquiryList", list);
    return "inquiry/index";
  }

  //詳細ページに遷移
  @GetMapping("{id}")
  public String show(@PathVariable("id") Integer id, Model model) {
    Inquiry inquiry = inquiryService.findById(id);
    model.addAttribute("title", "お問い合わせ詳細ページ");
    model.addAttribute("inquiryRequest", inquiry);
    return "inquiry/show";
  }

  //編集ページに遷移
  @PostMapping("{id}/edit")
  public String edit(InquiryForm inquiryForm, @PathVariable("id") Integer id, Model model) {
    Inquiry inquiry = inquiryService.findById(id);
    model.addAttribute("title", "お問い合わせ編集ページ");
    model.addAttribute("inquiryRequest", inquiry);
    return "inquiry/edit";
  }

  //新規問い合わせページで確認ボタンが押されたとき
  //入力に問題がなかった場合、確認画面ページに遷移
  //問題あった場合は新規問い合わせページに遷移
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

  //確認画面ページで戻るボタンが押されたとき、新規問い合わせページに遷移
  @PostMapping("/form")
  public String formBack(InquiryForm inquiryForm, Model model) {
    model.addAttribute("title", "新規問い合わせページ");
    return "inquiry/form";
  }

  //確認画面で送信がおされたとき、内容をデータベースに保存してお問い合わせ完了ページに遷移
  @PostMapping("/save")
  public String save(InquiryForm inquiryForm, Model model) {
    Inquiry inquiry = new Inquiry(inquiryForm.getName(), inquiryForm.getEmail(),inquiryForm.getContent());
    // inquiry.setName(inquiryForm.getName());
    // inquiry.setEmail(inquiryForm.getEmail());
    // inquiry.setContent(inquiryForm.getContent());
    inquiryService.save(inquiry);
    model.addAttribute("title", "お問い合わせ完了ページ");
    return "inquiry/complete";
  }

  //削除ボタンが押されたとき
  //問い合わせ消して、お問い合わせ一覧ページに遷移
  @DeleteMapping("{id}")
    public String destroy(@PathVariable Integer id) {
        inquiryService.deleteById(id);
        return "redirect:/inquiry/index";
    }

    //編集ページで「確認を反映」が押されたとき
    //内容に問題あったら編集画面のまま
    //なかったら詳細画面に遷移
    @PutMapping("{id}")
    public String update(@Validated InquiryForm inquiryForm, BindingResult result, Model model, @PathVariable Integer id, Inquiry inquiry) {

      if (result.hasErrors()) {

        Inquiry theInquiry = inquiryService.findById(id);
        model.addAttribute("title", "お問い合わせ編集ページ");
        model.addAttribute("inquiryRequest", theInquiry);
        return "inquiry/edit";
      }

        inquiry.setId(id);
        inquiryService.save(inquiry);
        model.addAttribute("title", "お問い合わせ詳細ページ");
        model.addAttribute("inquiryRequest", inquiry);
        return "/inquiry/show";
    }

}