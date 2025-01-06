package com.example.sparta_todo_develop.exception;

import com.example.sparta_todo_develop.exception.error.ErrorCode;

public class UserNotFoundException extends CustomRuntimeException {
    public UserNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}