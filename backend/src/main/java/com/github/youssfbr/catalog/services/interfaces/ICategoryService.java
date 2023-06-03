package com.github.youssfbr.catalog.services.interfaces;

import com.github.youssfbr.catalog.dtos.CategoryDTO;

import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> findAll();

}
