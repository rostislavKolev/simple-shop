package com.task.simpleshop.controller;

import com.task.simpleshop.dto.ProductDto;
import com.task.simpleshop.model.request.ProductRequestModel;
import com.task.simpleshop.model.response.ProductResponseModel;
import com.task.simpleshop.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ProductControllerTest {
    @InjectMocks
    ProductController productController;

    @Mock
    ProductServiceImpl productService;

    ProductDto persistedProduct = new ProductDto();
    final String PRODUCT_ID = "9b86232d-59df-43a3-ae41-5882a31e442e";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        this.persistedProduct.setProductId(PRODUCT_ID);
        this.persistedProduct.setName("TV");
        this.persistedProduct.setIsAvailable(true);
    }

    @Test
    void getProduct() {
        when(productService.getProduct(anyString())).thenReturn(persistedProduct);

        ProductResponseModel response = productController.getProduct(PRODUCT_ID).getBody();

        assertNotNull(response);
        assertEquals(PRODUCT_ID, response.getProductId());
        assertEquals(persistedProduct.getName(), response.getName());
        assertEquals(persistedProduct.getIsAvailable(), response.getIsAvailable());
    }

    @Test
    void createProduct() {

    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }
}