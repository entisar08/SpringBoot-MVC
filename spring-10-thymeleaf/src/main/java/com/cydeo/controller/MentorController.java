package com.cydeo.controller;


import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {
    @GetMapping("/register")
    public String register(Model model){

        model.addAttribute("mentor", new Mentor());

        List<String> batchList=new ArrayList<>(Arrays.asList("JD1", "JD2","JD3"));
        model.addAttribute("batchList", batchList);
        return "mentor/mentor-register";
    }

    //now get mapping model "mentor" sent empty mentor object to the form to be fi;lled . how you gonn capture this info
    //in post mapping
    //you need to pass it ti @Modell attribute(this will catch the data assigne to the attribute in the form) and assign it to new variable
    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor m){
        //return "mentor/mentor-confirmation";
          return "redirect:/mentor/register";
    }

}
