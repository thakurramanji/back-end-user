package com.ramanji.fullStackbackend.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Could not fount the user with this id "+ id);





    }
}
