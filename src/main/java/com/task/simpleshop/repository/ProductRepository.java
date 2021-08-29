package com.task.simpleshop.repository;

import com.task.simpleshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String name);

    Product findByProductId(String productId);
}
