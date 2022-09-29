package com.cydeo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController{

    //
@RequestMapping("/info")
    public String carInfo(@RequestParam String make, Model model){//when you run the method it will capture the value
//to extract the query parameter from url
    System.out.println(make);//this will print in the console
    model.addAttribute("make", make);

    return "car/car-Info";

    }


    @RequestMapping("/info2")
    public String carInfo2(@RequestParam(value = "make",required = false,defaultValue = "Acura") String make, Model model){//when you run the method it will capture the value
//to extract the query parameter from url
        System.out.println(make);//this will print in the console
        model.addAttribute("make", make);

        return "car/car-Info";

    }

    @RequestMapping("/info3")
    public String carInfo3(@RequestParam String year,Model model){//when you run the method it will capture the value
//to extract the query parameter from url
        //System.out.println(make);//this will print in the console
       // model.addAttribute("make", make);
        model.addAttribute("year", year);//this didnt work because I forgot to print it

        return "car/car-Info";

    }

    @RequestMapping("/info/{make}")
    public String getCarInfo(@PathVariable String make, Model model){//when you run the method it will capture the value

        model.addAttribute("make", make);
        System.out.println(make);

        return "car/car-Info";

    }


    /* RequestParam used in UI for search
    * pathVariable used alot in the api */
}
