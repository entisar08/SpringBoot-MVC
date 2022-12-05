package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.StudentDTO;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class SchoolController {

    private final TeacherService teacherService;
    private final StudentService studentService;

    public SchoolController(TeacherService teacherService, StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    //we want to get all teh teachers
    @GetMapping("/teachers ")
    public List<TeacherDTO> readAllTeacher(){
        List<TeacherDTO> teachers= teacherService.findAll();

        return teachers;

    }
    @GetMapping("/students ")
    public ResponseEntity<ResponseWrapper> readAllStudent(){
      return ResponseEntity.ok(new ResponseWrapper("students successfully retrieved ",studentService.findAll()));

    }




}
