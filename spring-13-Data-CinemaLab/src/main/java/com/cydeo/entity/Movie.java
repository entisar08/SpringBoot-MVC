package com.cydeo.entity;


import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Movie extends BaseEntity {

    private String name;


    @Column(columnDefinition ="DATE")
    private LocalDate releaseDate;

    private Integer duration;

    @Column(columnDefinition ="text")//text allows unlimited varchar
    private String Summary;

    @Enumerated(EnumType.STRING)
    private MovieType type;
    @Enumerated(EnumType.STRING)
    private MovieState state;

    private BigDecimal price;

    @ManyToMany//every movie has a genre
    @JoinTable(name="movie_genre_rel",
               joinColumns = @JoinColumn(name="movie_id"),
               inverseJoinColumns = @JoinColumn(name="genre_id"))
    private List<Genre> genreList;

    //here we dont need constructor
    //last time we needed to create an object and that is why we created constructor

}
