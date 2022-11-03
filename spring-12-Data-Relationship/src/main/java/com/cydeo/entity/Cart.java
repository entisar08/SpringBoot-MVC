package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
//@Table(name="Cart")
@Entity

public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;


    @ManyToMany// to change the table name and column names do the following
   @JoinTable(name="cart_item_rel",joinColumns = @JoinColumn(name="c_id"),inverseJoinColumns =  @JoinColumn(name="i_id"))
    private List<Item> itemList;






}
