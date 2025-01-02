package com.example.sparta_todo_develop.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class UserRequestDto {
    private String name;

    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "비밀번호는 최소 8자 이상이어야 하며, 영문자, 숫자, 특수 문자(@$!%*?&) 각각 최소 하나씩 포함해야 합니다.")
    private String password;

    @Email
    private String email;
}
