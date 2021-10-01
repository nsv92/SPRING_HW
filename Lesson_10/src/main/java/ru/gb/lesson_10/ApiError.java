package ru.gb.lesson_10;

public class ApiError {
    private int statusCode;
    private String message;

    public ApiError() {
    }

    public ApiError(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
