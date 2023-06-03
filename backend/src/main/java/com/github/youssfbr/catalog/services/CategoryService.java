package com.github.youssfbr.catalog.services;

import com.github.youssfbr.catalog.entities.Category;
import com.github.youssfbr.catalog.repositories.ICategoryRepository;
import com.github.youssfbr.catalog.services.interfaces.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

}
