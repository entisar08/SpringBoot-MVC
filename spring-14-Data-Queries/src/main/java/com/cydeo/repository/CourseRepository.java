package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    //find all courses by category: select * from courses where category=..
    List<Course> findAllByCategory(String Category);


    //find all courses by category and order the entiries by name
   List<Course> findAllByCategoryOrderByName(String Category);

   //checks if a course with the supplied name exists return true if exists false otherwise

    boolean existsByName(String name);

    //return the count for courses for the given category
    Integer countByCategory(String category);

    //find all courses that with the given course name string
    List<Course> findCourseByNameStartsWith(String pattern);
    List<Course> findByNameStartsWith(String pattern);


    //fina all courses by category and return stream
    //?1 positional parameter
    Stream<Course> streamAllByCategory(String category);


    //====================================================
    @Query("SELECT c from Course  c WHERE c.category = :category And c.rating > :rating")
    List<Course> retrieveAllByCategoryAndRatingGreaterThan(@Param("category")  String category, @Param("rating")  int rating);



}
