package com.github.youssfbr.catalog.services.interfaces;

import com.github.youssfbr.catalog.dtos.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> findAll();
    Page<CategoryDTO> findAllPaged(PageRequest pageRequest);
    CategoryDTO findById(Long id);
    CategoryDTO insert(CategoryDTO dto);
    CategoryDTO update(Long id, CategoryDTO dto);
    void delete(Long id);

}
