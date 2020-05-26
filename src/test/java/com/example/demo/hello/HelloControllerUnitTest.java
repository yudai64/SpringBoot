package com.example.demo.hello;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(HelloController.class)
@ExtendWith(SpringExtension.class)
@DisplayName("Helloコントローラのテスト")
public class HelloControllerUnitTest {
  
  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
  }

  @Test
  @DisplayName("localhost:8080にアクセスするとホームの画面が表示される")
  void ホームページにGETメッソドでアクセスする () throws Exception {

    this.mockMvc.perform(get("/"))
    .andExpect(status().isOk())
    .andExpect(view().name("hello"));
  }

  }
