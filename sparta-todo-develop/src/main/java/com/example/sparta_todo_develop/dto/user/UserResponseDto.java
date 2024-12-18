package com.example.sparta_todo_develop.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDto {
    private final Long id;
    private String name;
    private String email;
}
