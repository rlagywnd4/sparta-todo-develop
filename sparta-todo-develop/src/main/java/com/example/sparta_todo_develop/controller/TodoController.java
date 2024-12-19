package com.example.sparta_todo_develop.controller;

import com.example.sparta_todo_develop.dto.todo.TodoRequestDto;
import com.example.sparta_todo_develop.dto.todo.TodoResponseDto;
import com.example.sparta_todo_develop.dto.todo.UpdateTodoRequestDto;
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
     * save todo
     * @param requestDto
     * @return ResponseEntity.ok(responseDto)
     */
    @PostMapping
    public ResponseEntity<TodoResponseDto> saveTodo(@RequestBody TodoRequestDto requestDto){
        TodoResponseDto responseDto = todoService.saveTodo(requestDto);

        return ResponseEntity.ok(responseDto);
    }

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
