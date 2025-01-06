package com.example.sparta_todo_develop.exception;

import com.example.sparta_todo_develop.exception.error.ErrorCode;

public class TodoNotFoundException extends CustomRuntimeException {
    public TodoNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}