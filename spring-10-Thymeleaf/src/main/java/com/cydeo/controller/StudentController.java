package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//adding @request mapping on the class level to concatenate with all the endpoints provided

@Controller

@RequestMapping("/student")

public class StudentController {
    @RequestMapping("/register")
    public String register (Model model){
        model.addAttribute("students", DataGenerator.createStudent());//always use the attribute name in the thymeleaf and not the data directly
        return "student/register";
    }


}
