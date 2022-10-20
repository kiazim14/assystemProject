package com.springboot.exception;

public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException(String s) {
        super(s);
    }
}
