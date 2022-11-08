package com.example.jpa.core.exception;

final public class BlockUserException extends UserException {

    public BlockUserException(String userId) {
        super(String.format("BLOCK_USER_ID : (%s)", userId));
    }
}
