package com.tarka.tarka.repositories;


import com.tarka.tarka.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
