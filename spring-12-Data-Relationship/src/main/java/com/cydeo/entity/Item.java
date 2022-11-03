package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name="items")
@Entity

public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;


    private String name;
    private String code;

    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }
    @ManyToMany (mappedBy = "itemList")//to prevent creating another items-cart table table
    private List<Cart> carts;
}
