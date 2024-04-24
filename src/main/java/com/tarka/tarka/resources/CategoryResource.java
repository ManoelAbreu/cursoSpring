package com.tarka.tarka.resources;

import com.tarka.tarka.model.Category;
import com.tarka.tarka.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){

        List<Category> categories = service.findAll();
        return ResponseEntity.ok().body(categories);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(Long id){

        Category category = service.findById(id);
        return ResponseEntity.ok().body(category);

    }

}
