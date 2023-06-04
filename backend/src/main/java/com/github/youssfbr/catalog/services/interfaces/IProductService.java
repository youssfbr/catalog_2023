package com.github.youssfbr.catalog.services.interfaces;

import com.github.youssfbr.catalog.dtos.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IProductService {

    List<ProductDTO> findAll();
    Page<ProductDTO> findAllPaged(PageRequest pageRequest);
    ProductDTO findById(Long id);
    ProductDTO insert(ProductDTO dto);
    ProductDTO update(Long id, ProductDTO dto);
    void delete(Long id);

}
