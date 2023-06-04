package com.github.youssfbr.catalog.repositories;

import com.github.youssfbr.catalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
