package com.cydeo.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WelcomeController.class)//autoconfigure only the necessary beans
public class WelcomeControllerTest {
    @Autowired// in main package you can use constructor because autowired will be depreciated
    // soon but for testing this is not the case and we can still use it
    private MockMvc mvc;//we will mock requests
    @Test
    void welcome_Test() throws Exception {
        //first create request from RequistBuilder class and call the /welcome endpoint by sending get request
 //also you can provide headers body or any rquired data for the request
        RequestBuilder request= MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);
        // send the request
        MvcResult result=mvc.perform(request).andReturn();//like ping command perform will send the request
        //and get results will be saved in results
        //second verify response is "welcome"

        assertEquals(200, result.getResponse().getStatus());// in this method we pass expected first actual second
        assertEquals("welcome", result.getResponse().getContentAsString());
    }

    @Test
    void welcome_Test2() throws Exception {
        RequestBuilder request= MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("welcome"))
                .andReturn();
    }

}
