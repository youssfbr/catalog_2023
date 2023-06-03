package com.github.youssfbr.catalog.controllers;

import com.github.youssfbr.catalog.dtos.CategoryDTO;
import com.github.youssfbr.catalog.services.interfaces.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDTO> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

}
