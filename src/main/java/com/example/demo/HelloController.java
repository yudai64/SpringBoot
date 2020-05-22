package com.example.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

  private static Log log = LogFactory.getLog(HelloController.class);
  @RequestMapping("/")
  public String hello(Model model) {

    if(log.isInfoEnabled()){
    log.info("HelloControllerクラスが呼ばれた");
    }

    if(log.isWarnEnabled()){
      log.warn("警告ログ");
    }

    model.addAttribute("new_message", "新規問い合わせ");
    model.addAttribute("new_url", "/inquiry/form");
    model.addAttribute("index_message", "問い合わせ一覧");
    model.addAttribute("index_url", "/inquiry/index");
    model.addAttribute("title", "HelloWorld");

    return "hello";

  }
  
  
}