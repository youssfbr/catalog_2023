package com.github.youssfbr.catalog.controllers;

import com.github.youssfbr.catalog.entities.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping
    public List<Category> findAll() {
        ArrayList<Category> list = new ArrayList<>();
        list.add(new Category(1L, "Books"));
        list.add(new Category(2L, "Eletronics"));
        return list;
    }

}
