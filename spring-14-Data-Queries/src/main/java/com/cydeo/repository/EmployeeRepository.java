package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

import static org.hibernate.loader.Loader.SELECT;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //display all employee with email address
    List<Employee> findByEmail(String email);
    //display all employee with first name sth lastname sth and email address sth
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstname,String lastname,String email);
    //Display alll employee that first naem is not
    List<Employee> findByFirstNameIsNot(String firstname);
    //display all employee where last name startwith
    List<Employee> findByLastNameStartingWith(String pattern);
    //display all employees with salary less than
    List<Employee> findBySalaryGreaterThan(Integer salary);
    List<Employee> findBySalaryLessThan(Integer salary);
    //display all employees that has been hired between certain date
    List<Employee> findByHireDateBetween(LocalDate startWith,LocalDate endDate) ;
    // display all employee where salaries greater and equal to "" in order salary
     List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);
    //display top unique
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);
    //display all employee that do not have email address
    List<Employee> findByEmailIsNull();

    //JPQL

    @Query("SELECT  e FROM Employee e WHERE  e.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail();

    @Query("SELECT  e.salary FROM Employee e WHERE  e.email='amcnee1@google.es'")
    Integer retrieveEmployeeSalary();



}
