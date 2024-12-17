package com.example.sparta_todo_develop.dto.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoRequestDto {
    private final String userName;
    private String title;
    private String content;
}
