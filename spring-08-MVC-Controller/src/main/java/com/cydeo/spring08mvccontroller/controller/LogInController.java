package com.cydeo.spring08mvccontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogInController {

    @RequestMapping("/login")
    public String login(){

        return "login.html";
    }


        @RequestMapping("/welcome")
        public String welcome(){

            return "Student/welcome.html";
        }

    @RequestMapping()
    public String welcome2(){

        return "Student/welcome.html";
    }


}


