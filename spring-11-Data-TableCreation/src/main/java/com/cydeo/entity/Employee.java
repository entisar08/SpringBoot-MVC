package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;

    @Column(columnDefinition ="DATE")
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender ;
    private int Salary;





}
