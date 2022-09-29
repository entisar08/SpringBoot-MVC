package com.cydeo.controller;

import com.cydeo.Enum.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class MentorController {

    @RequestMapping("/mentor")
    public String getMentors(Model model){
        Mentor mentor1=new Mentor("jade","Fade", Gender.FEMALE, 34);
        Mentor mentor2=new Mentor("Baha","Balin", Gender.FEMALE, 35);
        Mentor mentor3=new Mentor("Madi","Fadi", Gender.FEMALE, 31);

        model.addAttribute("mentor1", mentor1);
        model.addAttribute("mentor2", mentor2);
        model.addAttribute("mentor3", mentor3);


        return "mentor/mentor";
    }
//OZZY solution
    /*@RequestMapping("/list")
    public String showList(Model model){
        List<Mentor> mentorList=new ArrayList<>();
        mentorList.add(new Mentor("jade","Fade", Gender.FEMALE, 34));
        mentorList.add(new Mentor("Baha","Balin", Gender.FEMALE, 35);
        mentorList.add(new Mentor("Madi","Fadi", Gender.FEMALE, 31);

        model.addAttribute("mentors", mentorList);



        return "mentor/mentor-list";
    }
*/

}
