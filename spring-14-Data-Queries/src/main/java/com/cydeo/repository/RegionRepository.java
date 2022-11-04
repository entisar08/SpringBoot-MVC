package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Integer> {
    //Display all region in Canada
   List<Region> findByCountry (String country);
    List<Region> getByCountryIgnoreCase(String country);
    //Display all regions with country naem including united
    List<Region> findByCountryContaining(String country);
    //display top two regions
    List<Region> findTop2ByCountry(String country);
    List<Region> findTopByCountry(String country);
    List<Region>  findTopByCountryContainsOrderByRegion(String country);



}
