package com.example.jpa.core.exception;

final public class DeleteUserException extends UserException {
    public DeleteUserException(String userId) {
        super(String.format("DELETE_USER_ID : (%s)", userId));
    }
}
