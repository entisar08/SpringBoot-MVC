package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor// with @Entity you should have no arg constructor
@Data

public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String make;
    private String model;
//create constructor without the id because db will generate the id
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }
}
