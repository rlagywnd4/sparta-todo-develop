package com.example.sparta_todo_develop.controller;

import com.example.sparta_todo_develop.dto.TodoRequestDto;
import com.example.sparta_todo_develop.dto.TodoResponseDto;
import com.example.sparta_todo_develop.dto.UpdateTodoRequestDto;
import com.example.sparta_todo_develop.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    /**
     * create todo
     * @param requestDto
     * @return ResponseEntity.ok(responseDto)
     */
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
     * find all todos
     * @return List<TodoResponseDto>
     */
    @GetMapping
    public ResponseEntity<List<TodoResponseDto>> findAll(){
        List<TodoResponseDto> responseDtos = todoService.findAll();

        return ResponseEntity.ok(responseDtos);
    }

    /**
     * find todo by id
     * @param id
     * @return ResponseEntity.ok(responseDto)
     */
    @GetMapping("/{id}")
    public ResponseEntity<TodoResponseDto> findById(@PathVariable Long id){
        TodoResponseDto responseDto = todoService.findById(id);

        return ResponseEntity.ok(responseDto);
    }

    /**
     * update todo by id
     * @param id
     * @param requestDto
     * @return ResponseEntity.ok(responseDto)
     */
    @PatchMapping("/{id}")
    public ResponseEntity<TodoResponseDto> updateTodo(@PathVariable Long id, @RequestBody UpdateTodoRequestDto requestDto){
        TodoResponseDto responseDto = todoService.updateTodo(id, requestDto.getTitle(), requestDto.getContent());

        return ResponseEntity.ok(responseDto);
    }

    /**
     * delete todo by id
     * @param id
     * @return ResponseEntity<>(HttpStatus.OK)
     */
    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
