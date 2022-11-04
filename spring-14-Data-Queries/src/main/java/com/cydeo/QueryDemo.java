package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {
  private final RegionRepository regionRepository;
  private final DepartmentRepository departmentRepository;
   private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        System.out.println("=========================Region ========================");
        System.out.println("Find By Country Canada" + regionRepository.findByCountry("Canada"));
        System.out.println(regionRepository.getByCountryIgnoreCase("United states"));
        System.out.println(regionRepository.findByCountryContaining("United States"));
        System.out.println("Find Top 2 region in United States" + regionRepository.findTop2ByCountry("United States"));
        System.out.println("Find Top 2 region order by region" + regionRepository.findTop2ByCountry("United States"));

        System.out.println("=========================Department ========================");

        System.out.println("Find by Department " + departmentRepository.findByDepartment("Furniture"));
        System.out.println("Find non duplicate distencit " + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));

        System.out.println("=========================Employee JPQL ========================");

        System.out.println("Find non Employee by email " + employeeRepository.retrieveEmployeeDetail());
        System.out.println("Find non Employee saalary by email " + employeeRepository.retrieveEmployeeSalary());
    }
}
