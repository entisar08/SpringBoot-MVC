package com.cydeo.repository;


import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {


    List<Department> findByDepartment(String depatment);

    //Display all department in the health division ,all the following method do the same job
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);
//display all department with division name ends with 'ics'
     List<Department> findByDivisionEndingWith(String pattern);


    //display top 3 department with division name includes 'Hea' without duplicate

    List<Department> findDistinctTop3ByDivisionContains(String pattern);



}
