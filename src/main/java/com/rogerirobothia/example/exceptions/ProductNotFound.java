package com.rogerirobothia.example.exceptions;

public class ProductNotFound extends RuntimeException{
    public ProductNotFound(String message) {
        super(message);
    }
}
