package com.example.sparta_todo_develop.exception;

import com.example.sparta_todo_develop.exception.error.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomRuntimeException extends RuntimeException {
    private final ErrorCode errorCode;
}
