package com.cydeo.service;


import com.cydeo.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

//we need to make it bean why?
public class EmployeeService {

    public static List<Employee> employeeList=new ArrayList<>();

    public void saveEmplyee(Employee employee){ //create employee
        employeeList.add(employee);
    }

    public List<Employee> readAllEmployees(){
        return employeeList;
    }



}
