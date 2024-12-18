package com.example.sparta_todo_develop.controller;

import com.example.sparta_todo_develop.dto.user.UserRequestDto;
import com.example.sparta_todo_develop.dto.user.UserResponseDto;
import com.example.sparta_todo_develop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    //TODO: Create
    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserRequestDto requestDto){
        UserResponseDto responseDto = userService.saveUser(requestDto);

        return ResponseEntity.ok(responseDto);
    }
    //TODO: Read
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll(){
        List<UserResponseDto> responseDtos = userService.findAll();

        return ResponseEntity.ok(responseDtos);
    }
    //TODO: Update
    //TODO: Delete
}