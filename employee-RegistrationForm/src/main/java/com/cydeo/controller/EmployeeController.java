package com.cydeo.controller;


import com.cydeo.bootstrap.DataGenerator;
import com.cydeo.model.Employee;
import com.cydeo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller

@RequestMapping("/employee")
public class EmployeeController {
    //to use employee service we need to create bean here DI
    private final EmployeeService employeeService;

    //create constructor
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/register")
    public String createEmployee(Model model) {
        model.addAttribute("employee", new Employee());

        model.addAttribute("stateList", DataGenerator.getAllStates());

        return "employee/employee-create";
    }
//by now to use bootstrap google it open the home page click on version
    // choose 4.1  and copy starter template


    @PostMapping("/insert")
    ///*this employee is the attribute name of model*/ the purpose of the memthod to save employee
    //it is equiped by employee service and it sis method to save employee
    public String insertEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult ,Model model) {

        if(bindingResult.hasErrors()){
            model.addAttribute("stateList", DataGenerator.getAllStates());
            return "employee/employee-create";
        }

        //a@model atribute will capture the employee from the register page

        employeeService.saveEmplyee(employee);


       // return "employee/employee-list";
        //you can return to register
        //you can return to confirmation bage
        //you can redirect it  to employee/employee-list
        return "redirect:/employee/list";//with redirect we are using endpoint
    }


    @GetMapping("/list")
    public String listEmployee(Model model) {
        //we added model to carry employee we captured to the thymeleaf page returned by this method


        model.addAttribute("employeeList", employeeService.readAllEmployees());

        return "employee/employee-list";// without redirect we are using the html path that contain the data

    }

}
