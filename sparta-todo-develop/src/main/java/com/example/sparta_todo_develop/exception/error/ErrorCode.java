package com.example.sparta_todo_develop.exception.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // user
    USER_NOT_FOUND_BY_ID(HttpStatus.NOT_FOUND, "해당 id를 가진 유저가 존재하지 않습니다"),
    USER_NOT_FOUND_BY_EMAIL(HttpStatus.NOT_FOUND, "해당 email를 가진 유저가 존재하지 않습니다"),
    SAME_PASSWORD(HttpStatus.NOT_FOUND, "현재 비밀번호와 동일한 비밀번호로 수정할 수 없습니다."),

    //TodoEntity
    TODO_NOT_FOUND_BY_ID(HttpStatus.NOT_FOUND, "해당 id를 가진 Todo가 존재하지 않습니다");

    private final HttpStatus status;
    private final String message;
}
