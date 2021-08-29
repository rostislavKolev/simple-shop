package com.task.simpleshop.service;

import com.task.simpleshop.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto product);

    ProductDto getProduct(String productId);

    ProductDto updateProduct(String productId, ProductDto productDto);

    void deleteProductById(String productId);

    List<ProductDto> getProductsBySubscriberId(String subscriberId);
}
