package com.github.youssfbr.catalog.services;

import com.github.youssfbr.catalog.dtos.CategoryDTO;
import com.github.youssfbr.catalog.repositories.ICategoryRepository;
import com.github.youssfbr.catalog.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.catalog.services.interfaces.ICategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDTO::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException("Entity not found."));
    }

}
