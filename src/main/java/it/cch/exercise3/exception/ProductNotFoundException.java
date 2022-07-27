package it.cch.exercise3.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Integer id) {
        super("Could not find Product " + id);
    }
}
