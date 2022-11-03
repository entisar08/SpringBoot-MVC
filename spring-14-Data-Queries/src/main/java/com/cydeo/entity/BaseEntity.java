package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass

public class BaseEntity {
    @Id
    private Integer id;


}
