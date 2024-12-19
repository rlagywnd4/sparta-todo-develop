package com.example.sparta_todo_develop.controller;

import com.example.sparta_todo_develop.dto.user.UserRequestDto;
import com.example.sparta_todo_develop.dto.user.UserResponseDto;
import com.example.sparta_todo_develop.entity.User;
import com.example.sparta_todo_develop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //TODO: Create
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserRequestDto requestDto){
        UserResponseDto responseDto = userService.saveUser(requestDto);

        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequestDto requestDto, HttpServletRequest request){
        // 이메일로 회원 찾고 비번으로 확인하고 session 발급
        User findUser = userService.findByEmail(requestDto.getEmail());

        if(!findUser.getPassword().equals(requestDto.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("wrong password");
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("key", "1234");

        return ResponseEntity.ok("success");
    }

    //TODO: Read
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll(){
        List<UserResponseDto> responseDtos = userService.findAll();

        return ResponseEntity.ok(responseDtos);
    }
    //TODO: Update
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @RequestBody UserRequestDto requestDto){
        UserResponseDto responseDto = userService.updateUser(id, requestDto.getName(), requestDto.getEmail());

        return ResponseEntity.ok(responseDto);
    }
    //TODO: Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}