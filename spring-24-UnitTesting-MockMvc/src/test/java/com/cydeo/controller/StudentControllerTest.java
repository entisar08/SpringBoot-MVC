package com.cydeo.controller;


import com.cydeo.dto.StudentDTO;
import com.cydeo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean// it can mock interfaces directly unlike @Mock that works directly with the bean
            //because it workd directly with application context
    StudentService studentService;

    @Test
    void getStudent_Test() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/student")// these should be started in a test method
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"firstName\": \"Mike\", \"lastName\":  \"Smith\", \"age\": 20}"))
                .andDo(print())
                .andReturn();

    }

    @Test
    void jassonAssert_Test() throws Exception{
        String expected= "{\"firstName\": \"Mike\", \"lastName\":  \"Smith\", \"age\": 20}";
        String actual= mvc.perform(MockMvcRequestBuilders.get("/student")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse().getContentAsString(); //trying to convert what we recieve as string
        JSONAssert.assertEquals(expected,actual,true);//
    }
    @Test
    void getStudents_Test() throws Exception {
        //in /students controller method we are using student service so we need to mock the behavior

        when(studentService.getStudents()).thenReturn(Arrays.asList(
                new StudentDTO("John", "Doe", 20),
                new StudentDTO("Tom", "Hanks", 50)
        ));         // Creating my stub (behavior for my mock object/StudentService obj)

        mvc.perform(MockMvcRequestBuilders.get("/students")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(content()
                        .json("[{\"firstName\": \"John\", \"lastName\":  \"Doe\", \"age\": 20}" +
                                ", {\"firstName\": \"Tom\", \"lastName\":  \"Hanks\", \"age\": 50}]"))
                .andDo(print())
                .andReturn();

    }



}
