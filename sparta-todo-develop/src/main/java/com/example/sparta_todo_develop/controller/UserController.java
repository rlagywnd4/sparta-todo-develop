package com.example.sparta_todo_develop.controller;

import com.example.sparta_todo_develop.dto.user.UserRequestDto;
import com.example.sparta_todo_develop.dto.user.UserResponseDto;
import com.example.sparta_todo_develop.entity.User;
import com.example.sparta_todo_develop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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

    /**
     * signup
     * @param requestDto
     * @return 생성한 user
     */
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> saveUser(@Valid @RequestBody UserRequestDto requestDto){
        UserResponseDto responseDto = userService.saveUser(requestDto);

        return ResponseEntity.ok(responseDto);
    }

    /**
     * login
     * @param requestDto
     * @param request
     * @return 성공 여부
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody UserRequestDto requestDto, HttpServletRequest request){
        // 이메일로 회원 찾고 비번으로 확인하고 session 발급
        User findUser = userService.findByEmail(requestDto.getEmail());

        if(!findUser.getPassword().equals(requestDto.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("wrong password");
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("key", "1234");

        return ResponseEntity.ok("success");
    }

    /**
     * find all users
     * @return users
     */
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll(){
        List<UserResponseDto> responseDtos = userService.findAll();

        return ResponseEntity.ok(responseDtos);
    }

    /**
     * update user
     * @param id
     * @param requestDto
     * @return updated user
     */
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDto requestDto){
        UserResponseDto responseDto = userService.updateUser(id, requestDto.getName(), requestDto.getEmail());

        return ResponseEntity.ok(responseDto);
    }

    /**
     * delete user
     * @param id
     * @return 성공여부
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}