package com.github.youssfbr.catalog.services;

import com.github.youssfbr.catalog.dtos.ProductDTO;
import com.github.youssfbr.catalog.entities.Product;
import com.github.youssfbr.catalog.repositories.IProductRepository;
import com.github.youssfbr.catalog.services.exceptions.DatabaseException;
import com.github.youssfbr.catalog.services.exceptions.ResourceNotFoundException;
import com.github.youssfbr.catalog.services.interfaces.IProductService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductDTO::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(PageRequest pageRequest) {
        return productRepository
                .findAll(pageRequest)
                .map(ProductDTO::new);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product entity = findProductById(id);
        return new ProductDTO(entity, entity.getCategories());
    }

    @Override
    @Transactional
    public ProductDTO insert(ProductDTO dto) {

        Product entity = new Product();
        entity.setName(dto.getName());

        entity = productRepository.save(entity);

        return new ProductDTO(entity);
    }


    @Override
    @Transactional
    public ProductDTO update(Long id, ProductDTO dto) {

        Product entity = findProductById(id);
        entity.setName(dto.getName());

        entity = productRepository.save(entity);

        return new ProductDTO(entity);
    }

    @Override
    public void delete(Long id) {
        try {
            findProductById(id);
            productRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id " + id + " not found."));
    }

}
