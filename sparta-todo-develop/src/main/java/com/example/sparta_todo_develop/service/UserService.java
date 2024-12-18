package com.example.sparta_todo_develop.service;

import com.example.sparta_todo_develop.dto.user.UserRequestDto;
import com.example.sparta_todo_develop.dto.user.UserResponseDto;
import com.example.sparta_todo_develop.entity.User;
import com.example.sparta_todo_develop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto saveUser(UserRequestDto requestDto) {
        User user = new User(requestDto.getName(), requestDto.getEmail());

        User savedUser = userRepository.save(user);

        return new UserResponseDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }
}
