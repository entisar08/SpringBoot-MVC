package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor


public class Genre extends BaseEntity{

    private String name;
    //@ManyToMany
   // private List<Movie> movie;

    //here we dont need constructor
    //last time we needed to create an object and that is why we created constructor

}
