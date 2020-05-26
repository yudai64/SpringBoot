package com.example.demo.inquiry;

import com.example.demo.service.InquiryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@DisplayName("Inquiryコントローラのテスト")
// @WebMvcTest
// @ContextConfiguration(classes = DemoApplication.class)
public class InquiryControllerUnitTest {

  private MockMvc mockMvc;

  @Mock
  InquiryService inquiryService;

  @InjectMocks
  InquiryController inquiryController;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(inquiryController).build();
  }

  @Test
  @DisplayName("新規問い合わせページにアクセス")
  void 新規問い合わせページにGETでアクセスする() throws Exception {
    this.mockMvc.perform(get("/inquiry/form"))
    .andExpect(status().isOk())
    .andExpect(model().attribute("title", "新規問い合わせページ"))
    .andExpect(view().name("inquiry/form"));
  }

  @Test
  @DisplayName("フォーム欄に問題がない場合は確認画面に遷移")
  void フォーム欄に問題がない場合は確認画面に遷移() throws Exception {
    this.mockMvc.perform(post("/inquiry/confirm")
    .param("name", "test")
    .param("email", "email@example.com")
    .param("content", "テスト投稿"))
    .andExpect(status().isOk())
    .andExpect(model().hasNoErrors())
    .andExpect(model().attribute("title", "確認ページ"))
    .andExpect(view().name("inquiry/confirm"));
  }

  @Test
  @DisplayName("フォーム欄に問題がある場合は新規問い合わせ画面に遷移")
  void フォーム欄に問題がある場合は新規問い合わせ画面に遷移() throws Exception {
    this.mockMvc.perform(post("/inquiry/confirm")
    .param("name", "")
    .param("email", "")
    .param("content", ""))
    .andExpect(status().isOk())
    .andExpect(model().hasErrors())
    .andExpect(model().attribute("title", "新規問い合わせページ"))
    .andExpect(view().name("inquiry/form"));
  }

  @Test
  @DisplayName("確認画面で戻るボタンを押すと新規問い合わせページに遷移")
  void 確認画面で戻るボタンを押すと新規問い合わせページに遷移() throws Exception {
    this.mockMvc.perform(post("/inquiry/form")
    .param("name", "test")
    .param("email", "email@example.com")
    .param("content", "テスト投稿"))
    .andExpect(status().isOk())
    .andExpect(model().attribute("title", "新規問い合わせページ"))
    .andExpect(view().name("inquiry/form"));
  }

  @Test
  @DisplayName("確認画面で送信ボタンを押すとお問い合わせ完了ページに遷移")
  void 確認画面で送信ボタンを押すとお問い合わせ完了ページに遷移() throws Exception {
    this.mockMvc.perform(post("/inquiry/save")
    .param("name", "test")
    .param("email", "email@example.com")
    .param("content", "テスト投稿"))
    .andExpect(status().isOk())
    .andExpect(model().attribute("title", "お問い合わせ完了ページ"))
    .andExpect(view().name("inquiry/complete"));
  }

  @Test
  @DisplayName("お問い合わせ一覧ページにアクセス")
  void お問い合わせ一覧ページにアクセス() throws Exception {
    this.mockMvc.perform(get("/inquiry/index"))
    .andExpect(status().isOk())
    .andExpect(model().attribute("title", "お問い合わせ一覧ページ"))
    .andExpect(view().name("inquiry/index"));
  }

}