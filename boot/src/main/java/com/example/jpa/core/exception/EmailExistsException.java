package com.example.jpa.core.exception;

final public class EmailExistsException extends UserException {

    public EmailExistsException(String message) {
        super(String.format("exists email :{}", message));
    }
}
