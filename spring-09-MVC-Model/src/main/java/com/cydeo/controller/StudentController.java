package com.cydeo.controller;

import com.cydeo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.IThymeleafBindStatus;

import java.time.LocalDate;
import java.util.Random;

@Controller
public class StudentController {

   @RequestMapping("/welcome")
    public String homePage(Model model){
       //how to pass data use methods of model interface
       //where to implement these methods
  model.addAttribute("name", "Cydeo");
  model.addAttribute("course", "MVC");
  //you can assign variable then add to the the page
       String subject=  "Spring Boot";
       model.addAttribute("subject", subject);
       int studentId = new Random().nextInt();
       model.addAttribute("id" , studentId);
       LocalDate dt= LocalDate.now();
       model.addAttribute("date",dt);

       Student student= new Student(1, "mike ", "steve");
       model.addAttribute("student", student );







        return "student/welcome";
    }
}
