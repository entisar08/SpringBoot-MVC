package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.IThymeleafBindStatus;

@Controller
public class StudentController {

   @RequestMapping("/welcome")
    public String homePage(Model model){
       //how to pass data use methods of model interface
       //where to implement these methods
  model.addAttribute("name", "Cydeo");
  model.addAttribute("course", "MVC");

        return "student/welcome";
    }
}
