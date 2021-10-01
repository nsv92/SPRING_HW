package ru.gb.lesson_10.carts;

public class CartException extends RuntimeException{

    public CartException(String message) {
        super(message);
    }

    public CartException(String message, Throwable cause) {
        super(message, cause);
    }
}
