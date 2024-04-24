package com.tarka.tarka.repositories;

import com.tarka.tarka.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long > {
}
