package com.task.simpleshop.exceptions;

public class ProductServiceException extends RuntimeException{

    private static final long serialVersionUID = -7772238391590609738L;

    public ProductServiceException(String message) {
        super(message);
    }
}
