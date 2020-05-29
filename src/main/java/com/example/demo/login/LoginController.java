package com.example.demo.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
public class LoginController {

  private static Log log = LogFactory.getLog(LoginController.class);

  @RequestMapping(value = "/login", method = RequestMethod.GET)
	public String index(Model model) {

    log.info("loginにGet");
		model.addAttribute("isError",false);
	    return "login/loginForm";
	}
	
	@RequestMapping(value = "/login-error", method = RequestMethod.GET)
	public String loginError(Model model) {

    log.info("login-errorにGet");
		 model.addAttribute("isError",true);
		 return "login/loginForm";
  }
  
  @PostMapping("/success")
    public String loginsuccess(){
        
        return "hello";
    }
}