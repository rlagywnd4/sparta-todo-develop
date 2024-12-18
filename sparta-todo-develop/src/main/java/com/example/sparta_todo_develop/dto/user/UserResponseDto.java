package com.example.sparta_todo_develop.dto.user;

import com.example.sparta_todo_develop.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDto {
    private final Long id;
    private String name;
    private String email;

    public UserResponseDto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
