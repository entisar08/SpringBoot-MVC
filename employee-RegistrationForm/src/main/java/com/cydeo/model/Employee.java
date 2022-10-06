package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @NotBlank //include not null and not empty and nut blank
    @Size(max=12,min=2 )// these annotation should be on top of the fields ment to be validated

    private String firstName;
    private String lastName ;
//thymelef accepts yyyy-MM-dd but local date accepts mm-dd-yyyy
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDay;
    private String email;
    private String password;
    private String address;
    private String address2;
    private String city;
    private String state;
    private String zipcode;



}
