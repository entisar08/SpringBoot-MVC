package com.cydeo.controller;


import com.cydeo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/employee")
public class EmployeeController {
 @GetMapping("/register")
    public String createEmployee(Model model){
        model.addAttribute("employee",new Employee());

        return"employee/employee-create";
    }
//by now to use bootstrap google it open the home page click on version
    // choose 4.1  and copy starter template

}
