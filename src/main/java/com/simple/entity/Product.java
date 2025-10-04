package com.simple.entity;

import module.java.base.Entity;
import module.java.base.GeneratedValue;
import module.java.base.GenerationType;
import module.java.base.Id;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;
    
    private Integer quantity;
}
