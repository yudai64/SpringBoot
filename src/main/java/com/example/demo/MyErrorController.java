package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController{

  private static Log log = LogFactory.getLog(MyErrorController.class);

  @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
       
      log.info("MyErrorControllerクラスが呼ばれた");

      Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
       if (status != null) {
        Integer statusCode = Integer.valueOf(status.toString());

        if(statusCode == HttpStatus.NOT_FOUND.value()) {
          log.info("404エラー");
          model.addAttribute("statusCode", statusCode);
          return "error/404";
        }
        else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
          model.addAttribute("statusCode", statusCode);
          return "error/500";
        }
      }
      log.info("これはなんのエラー？");
        return "error/other";
    }

    @Override
    public String getErrorPath() {
      return "/error";
    }

}