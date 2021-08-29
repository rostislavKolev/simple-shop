package com.task.simpleshop.exceptions;

public class SubscriberServiceException extends RuntimeException{

    private static final long serialVersionUID = -7772238391590609738L;

    public SubscriberServiceException(String message) {
        super(message);
    }
}
