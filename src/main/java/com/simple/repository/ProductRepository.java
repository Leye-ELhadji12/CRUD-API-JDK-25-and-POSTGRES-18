package com.simple.repository;

import module.java.base.JpaRepository;
import module.java.base.Repository;

import com.simple.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
