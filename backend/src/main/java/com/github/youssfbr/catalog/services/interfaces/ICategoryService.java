package com.github.youssfbr.catalog.services.interfaces;

import com.github.youssfbr.catalog.entities.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

}
