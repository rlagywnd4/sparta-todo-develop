package com.example.sparta_todo_develop.controller;

import com.example.sparta_todo_develop.dto.TodoRequestDto;
import com.example.sparta_todo_develop.dto.TodoResponseDto;
import com.example.sparta_todo_develop.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    // TODO: create
    @PostMapping
    public ResponseEntity<TodoResponseDto> createTodo(@RequestBody TodoRequestDto requestDto){
        TodoResponseDto responseDto = todoService.createTodo(requestDto);

        return ResponseEntity.ok(responseDto);
    }

    // TODO: read
    //      전체 일정 조회
    //          조건: 수정일, 작성자명(조건 중 한 가지만을 충족하거나, 둘 다 충족을 하지 않을 수도, 두 가지를 모두 충족할 수도 있습니다.)
    //      선택 일정 조회    조건: 고유 식별자(id)를 사용하여 조회

    /**
     * 모든 todo 반환
     * @return List<TodoResponseDto>
     */
    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> getAllTodos(){
        List<TodoResponseDto> responseDtos = todoService.getTodos();

        return ResponseEntity.ok(responseDtos);
    }

    // TODO: update
    // TODO: delete

}
