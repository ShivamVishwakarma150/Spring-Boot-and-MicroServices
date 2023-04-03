package com.shivam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivam.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
