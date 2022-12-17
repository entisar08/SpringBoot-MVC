package com.cydeo.entity;

import lombok.Data;

import javax.persistence.*;



import javax.persistence.*;
import javax.persistence.Column;

@Data
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "rating")
    private int rating;

    @Column(name = "description")
    private String description;

}
