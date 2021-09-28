package ru.gb.lesson_9.products;

public class ProductException {

    private String message;
    private int statusCode;

    public ProductException(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
