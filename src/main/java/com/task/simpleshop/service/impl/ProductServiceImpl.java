package com.task.simpleshop.service.impl;

import com.task.simpleshop.exceptions.ProductServiceException;
import com.task.simpleshop.domain.Product;
import com.task.simpleshop.dto.ProductDto;
import com.task.simpleshop.repository.ProductRepository;
import com.task.simpleshop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto getProduct(String productId) {
        Product product = productRepository.findByProductId(productId);
        if (product == null) {
            throw new ProductServiceException("Product with ID: " + productId + " not found");
        }
        ModelMapper modelMapper = new ModelMapper();
        ProductDto returnValue = modelMapper.map(product, ProductDto.class);
        return returnValue;
    }

    @Override
    public List<ProductDto> getProductsBySubscriberId(String subscriberId) {
        //TODO: implement getProductsBySubscriberId
        return null;
    }


    public ProductDto createProduct(ProductDto newProduct) {
        if (productRepository.findByName(newProduct.getName()) != null) {
            throw new ProductServiceException("Product already exists");
        }
        ModelMapper modelMapper = new ModelMapper();
        Product productEntity = modelMapper.map(newProduct, Product.class);
        productEntity.setProductId(UUID.randomUUID().toString());
        productEntity.setCreationDate(Timestamp.from(Instant.now()));
        this.productRepository.save(productEntity);
        ProductDto returnValue = modelMapper.map(productEntity, ProductDto.class);

        return returnValue;
    }

    @Override
    public ProductDto updateProduct(String productId, ProductDto newProduct) {
        Product product = productRepository.findByProductId(productId);
        if (product == null) {
            throw new ProductServiceException("Product with ID: " + productId + " not found.");
        }

        product.setName(newProduct.getName());
        product.setIsAvailable(newProduct.getIsAvailable());
        product = productRepository.save(product);
        ModelMapper modelMapper = new ModelMapper();
        ProductDto returnValue = modelMapper.map(product, ProductDto.class);

        return returnValue;
    }

    @Override
    public void deleteProductById(String productId) {
        Product product = productRepository.findByProductId(productId);
        if (product == null) {
            throw new ProductServiceException("Product with ID: " + productId + " not found");
        }
        productRepository.delete(product);
    }
}
