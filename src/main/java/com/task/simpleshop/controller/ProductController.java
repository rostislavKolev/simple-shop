package com.task.simpleshop.controller;

import com.task.simpleshop.dto.ProductDto;
import com.task.simpleshop.model.request.ProductRequestModel;
import com.task.simpleshop.model.response.ProductResponseModel;
import com.task.simpleshop.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/{productId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProductResponseModel> getProduct(@PathVariable String productId) {
        ProductDto productDto = productService.getProduct(productId);
        ModelMapper modelMapper = new ModelMapper();
        ProductResponseModel responseModel = modelMapper.map(productDto, ProductResponseModel.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @GetMapping(path = "/{subscriberId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<ProductResponseModel>> getProductsBySubscriberId(@PathVariable String subscriberId) {
        List<ProductDto> productDto = productService.getProductsBySubscriberId(subscriberId);
        ModelMapper modelMapper = new ModelMapper();
        //TODO:...
        ProductResponseModel responseModel = modelMapper.map(productDto, ProductResponseModel.class);

        return null;
    }


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,}, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProductResponseModel> createProduct(@RequestBody ProductRequestModel productRequest) {
        ModelMapper modelMapper = new ModelMapper();
        ProductDto productDto = modelMapper.map(productRequest, ProductDto.class);
        productDto = productService.createProduct(productDto);
        ProductResponseModel responseModel = modelMapper.map(productDto, ProductResponseModel.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
    }

    @PutMapping(path = "/{productId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE,},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<ProductResponseModel> updateProduct(@PathVariable String productId, @RequestBody ProductRequestModel productRequest) {
        ModelMapper modelMapper = new ModelMapper();
        ProductDto newProductDto = modelMapper.map(productRequest, ProductDto.class);
        newProductDto = productService.updateProduct(productId, newProductDto);
        ProductResponseModel responseModel = modelMapper.map(newProductDto, ProductResponseModel.class);

        return ResponseEntity.status(HttpStatus.OK).body(responseModel);
    }

    @DeleteMapping(path = "/{productId}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity deleteProduct(@PathVariable String productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
